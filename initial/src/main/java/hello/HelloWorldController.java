package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public Greeting sayHello(@RequestParam(name="name", required=false,
            defaultValue="Stranger") List<String> names){
       return greetingService.sayHello(names);
    }


    @GetMapping("/greetings")
    @ResponseBody
    public List<Greeting> showList(){
        return greetingService.findGreeting();
    }

    @PostMapping("/greetings")
    @ResponseBody
    public Greeting addGreeting(@RequestBody AddNamesDTO dto){
        return greetingService.addGreeting(Arrays.asList(dto.name));
    }
}