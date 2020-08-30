package com.sqh.blog.controller.admin;

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
@RequestMapping("/admin")
public class AdminPostsController {

    @Autowired
    private PostViewDataMapper mapper;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    private final String VIEW_PREFIX = "admin/";

    @GetMapping
    public String posts(Model model) {
        User user = getActorUser();
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", mapper.map(posts, user));

        return VIEW_PREFIX + "home";
    }

    @GetMapping("/posts/detail/{id}")
    public String detailPost(@PathVariable long id, Model model) {
        User actorUser = getActorUser();
        Post post = postService.findPostById(id).orElse(null);

        if (post != null) {
            model.addAttribute("post", mapper.map(post, actorUser));
        } else {
            model.addAttribute("message", "You are not permitted to view this post");
        }

        return VIEW_PREFIX + "post-detail";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, RedirectAttributes redirectAttributes) {
        Post post = postService.findPostById(id).orElse(null);
        if (post != null) {
            postService.deletePost(post);
        } else {
            redirectAttributes.addFlashAttribute("message", "Operation is not permitted");
        }

        return "redirect:/admin";
    }

    @GetMapping("/posts/approve/{id}")
    public String approvePost(@PathVariable long id, @RequestParam(required = false) boolean detailPage, Model model) {
        Post post = postService.findPostById(id).orElse(null);
        if (post != null) {
            postService.approvePost(post);

            if (detailPage) {
                return "redirect:/admin/posts/detail/" + post.getId();
            }
        }

        return "redirect:/admin";
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
