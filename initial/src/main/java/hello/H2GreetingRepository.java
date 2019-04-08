package hello;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2GreetingRepository implements GreetingRepository{
    private final JdbcTemplate jdcbTemplate;

    public H2GreetingRepository(JdbcTemplate jdcbTemplate) {
        this.jdcbTemplate = jdcbTemplate;
    }

    @Override
    public void save(Greeting greeting) {
        jdcbTemplate.update("INSERT INTO greeting(id, name) values(?,?)", greeting.getId(), greeting.getName());
    }

    @Override
    public List<Greeting> list() {
        return jdcbTemplate.query("SELECT id, name FROM greeting",
                (rs, rowNum) -> new Greeting(rs.getString("id"),
                        rs.getString("name")));
    }
}
