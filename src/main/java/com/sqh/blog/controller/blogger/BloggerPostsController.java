package com.sqh.blog.controller.blogger;

import com.sqh.blog.controller.form.PostForm;
import com.sqh.blog.controller.mapper.PostViewDataMapper;
import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;
import com.sqh.blog.service.PostService;
import com.sqh.blog.service.UserService;
import com.sqh.blog.validator.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/m")
public class BloggerPostsController {

    @Autowired
    private PostViewDataMapper mapper;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostValidator postValidator;

    private final String VIEW_PREFIX = "blogger/";

    @GetMapping
    public String posts(Model model) {
        User user = getActorUser();
        List<Post> posts = postService.findApprovedPostsIncluding(user);
        model.addAttribute("posts", mapper.map(posts, user));

        return VIEW_PREFIX + "home";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("postForm", new PostForm());

        return VIEW_PREFIX + "post-create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute PostForm postForm, BindingResult bindingResult) {
        postValidator.validate(postForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return VIEW_PREFIX + "post-create";
        }

        Post post = postService.createPost(postForm.getTitle(), postForm.getText(), getActorUser());

        return "redirect:/m/posts/detail/" + post.getId();
    }

    @GetMapping("/posts/detail/{id}")
    public String detailPost(@PathVariable long id, Model model) {
        User actorUser = getActorUser();
        Post post = postService.findApprovedPostOrOwnPost(id, actorUser);

        if (post != null) {
            model.addAttribute("post", mapper.map(post, actorUser));
        } else {
            model.addAttribute("message", "You are not permitted to view this post");
        }

        return VIEW_PREFIX + "post-detail";
    }

    @GetMapping("/posts/like/{id}")
    public String likePost(@PathVariable long id, @RequestParam(required = false) boolean detailPage, Model model) {
        User actorUser = getActorUser();
        Post post = postService.findApprovedPostExcluding(id, actorUser);
        if (post != null) {
            postService.likePost(post, actorUser);
            model.addAttribute("post", mapper.map(post, actorUser));
        }

        model.addAttribute("detailPage", detailPage);

        return VIEW_PREFIX + "single-post";
    }

    @GetMapping("/posts/dislike/{id}")
    public String dislikePost(@PathVariable long id, @RequestParam(required = false) boolean detailPage, Model model) {
        User actorUser = getActorUser();
        Post post = postService.findApprovedPostExcluding(id, actorUser);
        if (post != null) {
            postService.dislikePost(post, actorUser);
            model.addAttribute("post", mapper.map(post, actorUser));
        }

        model.addAttribute("detailPage", detailPage);

        return VIEW_PREFIX + "single-post";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, RedirectAttributes redirectAttributes) {
        User actorUser = getActorUser();
        Post post = postService.findPostByUser(id, actorUser).orElse(null);
        if (post != null) {
            postService.deletePost(post);
        } else {
            redirectAttributes.addFlashAttribute("message", "Operation is not permitted");
        }

        return "redirect:/m";
    }

    @GetMapping("/posts/approve/{id}")
    public String approvePost(@PathVariable long id, @RequestParam(required = false) boolean detailPage, Model model) {
        User actorUser = getActorUser();
        Post post = postService.findPostById(id).orElse(null);
        if (post != null) {
            postService.approvePost(post);
            model.addAttribute("post", mapper.map(post, actorUser));
        } else {
            model.addAttribute("message", "Operation is not permitted");
        }

        model.addAttribute("detailPage", detailPage);

        return VIEW_PREFIX + "single-post";
    }

    private User getActorUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User actorUser = null;

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            actorUser = userService.findByUsername(currentUserName).orElse(null);
        }

        return actorUser;
    }
}
