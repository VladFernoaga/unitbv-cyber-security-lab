package ro.vladfernoaga.controller;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/user")
	public User getUser(@RequestParam(value = "name") String name) {
		return new User(counter.incrementAndGet(), name, new Random().nextInt(99));
	}
	

	@GetMapping("/userAdmin")
	public User getUserAdmin(@RequestParam(value = "name") String name) {
		return new User(counter.incrementAndGet(), name, new Random().nextInt(99));
	}

	@PostMapping("/user")
	public String addUser(@RequestBody User greeting) {
		return "User added sucessfuly";
	}
	
	@GetMapping("/public")
	public String getPublic() {
		return "Public-1";
	}
}
