package com.sqh.blog.controller.admin;

import com.sqh.blog.controller.mapper.PostViewDataMapper;
import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;
import com.sqh.blog.service.PostService;
import com.sqh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Post post = postService.getPost(id);
        model.addAttribute("post", mapper.map(post, actorUser));
        return VIEW_PREFIX + "post-detail";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post post = postService.getPost(id);
        postService.deletePost(post);
        return "redirect:/admin";
    }

    @GetMapping("/posts/approve/{id}")
    public String approvePost(@PathVariable long id, @RequestParam(required = false) boolean detailPage, Model model) {
        Post post = postService.getPost(id);
        postService.approvePost(post);
        if (detailPage) {
            return "redirect:/admin/posts/detail/" + post.getId();
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
