package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class HelloWorldController {
    private final GreetingService greetingService;

    public HelloWorldController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name1", required=false,
            defaultValue="Stranger") String name1, @RequestParam(name="name2", required=false,
            defaultValue="Stranger") String name2) {
        List<String> names = new ArrayList<>();
        names.add(name1);
        names.add(name2);

       return greetingService.sayHello(names);
    }

}