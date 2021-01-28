package springExample;

import org.springframework.stereotype.Component;

@Component
public class ComponentA implements ComponentAInterface {
    @Override
    public void doAThing() {
        System.out.println("LOL1");
    }
}
