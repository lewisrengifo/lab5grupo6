package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sw2.lab5.Entity.post;
import sw2.lab5.Repository.PostRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;
    @GetMapping("/post")
    public String listaPost(Model model){

        List<post> listapost=postRepository.findAll();
        model.addAttribute("lista",listapost);
        return "post/lista";
    }
    @GetMapping("/borrar")
    public String borrarpost(@RequestParam("id") int id){
        Optional<post> opt=postRepository.findById(id);
        if(opt.isPresent())
        {
            postRepository.deleteById(id);
        }
        return "redirect:/post";

    }

}
