package hello;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GreetingService {
    public Greeting sayHello(List<String> names){
        return new Greeting(UUID.randomUUID().toString(), String.join(",", names));
    }
}
