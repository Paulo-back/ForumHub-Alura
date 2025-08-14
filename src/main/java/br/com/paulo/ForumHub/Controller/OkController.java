package br.com.paulo.ForumHub.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ok")
public class OkController {

    @GetMapping
    public String ok(){

        return "Apenas Ok";

    }
}
