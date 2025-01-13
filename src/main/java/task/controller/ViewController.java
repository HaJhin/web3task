package task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String index() {
        return "/task/index.html";
    }

    @GetMapping("/write")
    public String write() {
        return "/task/write.html";
    }

    @GetMapping("/list")
    public String list() {
        return "/task/list.html";
    }
}
