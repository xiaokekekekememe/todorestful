package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "%s!";
    private final AtomicLong counter = new AtomicLong();
    List<Greeting> greetings = new ArrayList<Greeting>();
    
   
    @RequestMapping( value = "/api/tasks/", method = RequestMethod.GET)
    public Greeting tasks(@RequestParam(value="name", defaultValue="Restful API homework") String name) {
    	Greeting greeting = new Greeting((int) counter.incrementAndGet(), template, new Date());
    	greetings.add(greeting);
        return greeting;
    }
    @GetMapping("/api/tasks1/")
    public List<Greeting> tasks1() {
    	
        return greetings;
    }
    @GetMapping("/api/tasksi/{id}")
    public Greeting tasksi(@PathVariable("id") int id) {
    	for (Greeting greeting : greetings) {
    	if (greeting.getId() == id) {
			return greeting;
    	}
    	}
        return null;
    }
    @GetMapping("/api/del/{id}")
    public List<Greeting> del(@PathVariable("id") int id) {
    	if (greetings.contains(greetings.get(id))) {
			greetings.remove(greetings.get(id-1));
		}
		
    	System.out.println("fdsfa");
        return greetings;
    }
}