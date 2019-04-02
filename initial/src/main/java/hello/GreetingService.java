package hello;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting sayHello(List<String> names) {
        Greeting greeting = new Greeting(UUID.randomUUID().toString(), String.join(", ", names));
        greetingRepository.save(greeting);
        return greeting;
    }
}
