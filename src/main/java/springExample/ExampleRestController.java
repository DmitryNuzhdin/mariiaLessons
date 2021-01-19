package springExample;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class ExampleRestController {
    ExampleEntityRepository exampleEntityRepository;

    public ExampleRestController(ExampleEntityRepository exampleEntityRepository) {
        this.exampleEntityRepository = exampleEntityRepository;
    }

    @RequestMapping(path = "/test")
    public String testPath(){
        return "IT'S A TEST!";
    }

    @RequestMapping(path = "/params/{c}")
    public String params(@RequestParam(value = "a", defaultValue = "qwe") String a,
                         @RequestParam(value = "b", defaultValue = "qwe") String b,
                         @PathVariable("c") String c){
        return "param a = " + a + ";param b = " + b + ";param c = " + c;
    }

    @RequestMapping(path = "/params", method = RequestMethod.POST)
    public String params(@RequestParam(value = "a", defaultValue = "qwe") String a,
                         @RequestParam(value = "b", defaultValue = "qwe") String b){
        return params(a, b, "default_c");
    }

    @RequestMapping(path = "/exampleEntity")
    public ExampleEntity exampleEntity(){
        return new ExampleEntity(13, 5.7);
    }

    @RequestMapping(path = "/exampleEntityCount")
    public Long exampleEntityCount(){
        return exampleEntityRepository.count();
    }

}
