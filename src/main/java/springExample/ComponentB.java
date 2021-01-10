package springExample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComponentB {
    private ComponentAInterface componentAInterface;
    private List<ComponentAInterface> componentAInterfaceList;

    public ComponentB(ComponentAInterface componentAInterface, List<ComponentAInterface> componentAInterfaceList) {
        this.componentAInterface = componentAInterface;
        this.componentAInterfaceList = componentAInterfaceList;
    }

    void run(){
        componentAInterface.doAThing();
    }
}
