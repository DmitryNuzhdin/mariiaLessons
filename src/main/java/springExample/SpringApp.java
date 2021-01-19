package springExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringApp.class);
        ComponentB componentB = ctx.getBean(ComponentB.class);
        componentB.run();

        ExampleEntityRepository repo = ctx.getBean(ExampleEntityRepository.class);
        ExampleEntity e = new ExampleEntity(5, 1.5);
        repo.save(e);
        repo.save(new ExampleEntity(6, 1.5));

        repo.findAll().forEach(exampleEntity -> System.out.println(exampleEntity.toString()));


    }
}
