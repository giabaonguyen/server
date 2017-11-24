package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repository.UserRepository;

@RestController    // This means that this class is a Controller
@RequestMapping("/api") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getNoteById(@PathVariable(value = "user_id") Integer user_id) {
	    User user = userRepository.findOne(user_id);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateNote(@PathVariable(value = "user_id") Integer user_id, 
	                                       @Valid @RequestBody User detail) {
	    User note = userRepository.findOne(user_id);
	    if(note == null) {
	        return ResponseEntity.notFound().build();
	    }
	    note.setUserName(detail.getUserName());
	    note.setPassword(detail.getPassword());

	    User updatedNote = userRepository.save(note);
	    return ResponseEntity.ok(updatedNote);
	}
}