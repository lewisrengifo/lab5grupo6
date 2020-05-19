package sw2.lab5.Controllers;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sw2.lab5.Entity.Post;
import sw2.lab5.Repository.PostRepository;

import java.util.Optional;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/list")
    public String listarpost(Model model) {
        model.addAttribute("listapost", postRepository.findAll()):
        return "/post/list";

    }

    @GetMapping("/post/create")
    public String nuevopost() {
        return "/post/create";
    }

    @GetMapping("/post/edit")
    public String editpost(Model model, @ModelAttribute("post") Post post, @RequestParam("id") int id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            post = optionalPost.get();
            model.addAttribute("post", post);
            return "/post/form";
        } else {

            return "/post/list";
        }
    }
    @PostMapping("/guardar")
    public String guardar (@ModelAttribute("post") Post post){
        postRepository.save(post);
        return "redirect: /post/list";
    }
    
}
