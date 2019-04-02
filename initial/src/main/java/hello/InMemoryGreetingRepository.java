package hello;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryGreetingRepository implements GreetingRepository {
    @Override
    public void save(Greeting greeting) {

    }
}
