package hello;

import java.util.List;

public interface GreetingRepository {
    void save(Greeting greeting);

    List<Greeting> list();
}
