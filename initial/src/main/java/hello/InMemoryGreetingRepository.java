package hello;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryGreetingRepository implements GreetingRepository {
    private final List<Greeting> greetings = new ArrayList<>();

    @Override
    public void save(Greeting greeting) {
        greetings.add(greeting);
    }
}
