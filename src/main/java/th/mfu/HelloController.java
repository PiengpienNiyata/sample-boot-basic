package th.mfu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String hello() {
        return "Hello World!";
    }

    String[] validNames = {"Noey", "John", "Nami"};

    @GetMapping("/hi/{name}")
    ResponseEntity<String> hi(@PathVariable String name){
        // return new ResponseEntity<>("Hi " + name, HttpStatus.ok);
       // return ResponseEntity.ok("Hi " + name); //ดูชัดเจนมากกว่า

       for(String validName : validNames){
        if(validName.equals(name))
           return ResponseEntity.ok("Hi " + name);

       }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
   
}
