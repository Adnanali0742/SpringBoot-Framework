package com.example.demo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adv.db.project.dataModels.Movies;
import adv.db.project.dataModels.User;
import adv.db.project.services.data.api.DataAccessException;
import adv.db.project.services.data.api.IMovies;
import adv.db.project.services.data.api.IUser;

@RestController
public class TestController {

	private static final String BASE_PATH = "/Movies";
	private static final String BASE_PATH_2 = "/User";
//	@Inject
//	ISeenMoviesDAO dao;

	@Inject
	IMovies moviesDAO;
	
	@Inject
	IUser userDAO;

	@GetMapping(path= BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 void Movie(@PathVariable("id") Integer id) throws DataAccessException {
		Movies movies = moviesDAO.getById(Movies.class, Integer.valueOf(id));
		
	}
	
	@GetMapping(path= BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movies>> test() throws DataAccessException{
		Movies criterion = new Movies();
		List<Movies> search = moviesDAO.search(criterion);
		return ResponseEntity.ok(search);
		
	}
	
	
	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movies> create(@RequestBody Movies movies) {
		try {
			moviesDAO.create(movies);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(movies);
		}
		return ResponseEntity.ok(movies);
//		return ResponseEntity.created(URI.create(BASE_PATH + "/" + seenMovies.getId())).build();

	}
	
	@PutMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movies> update(@RequestBody Movies movies) {
		try {
			moviesDAO.update(movies);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(movies);
		}
		return ResponseEntity.ok(movies);
//		return ResponseEntity.created(URI.create(BASE_PATH + "/" + seenMovies.getId())).build();

	}
		
//	@DeleteMapping(path= BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<SeenMovies> delete(@PathVariable("id") String id) throws DataAccessException {
//		try {
//			SeenMovies criterion = new SeenMovies();
//			criterion.setId(Integer.valueOf(id));
//			dao.delete(criterion)
//		} catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	} 
	
	@DeleteMapping(path = BASE_PATH + "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	  void deleteMovie(@PathVariable("id") Integer id) throws DataAccessException {
		Movies seenMovies = moviesDAO.getById(Movies.class, Integer.valueOf(id));
		moviesDAO.delete(seenMovies);
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(path= BASE_PATH_2 + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 void User(@PathVariable("id") Integer id) throws DataAccessException {
		User user = userDAO.getById(User.class, Integer.valueOf(id));
		
	}
	
	@GetMapping(path= BASE_PATH_2, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> testUser() throws DataAccessException{
		User criterion = new User();
		List<User> search = userDAO.search(criterion);
		return ResponseEntity.ok(search);
		
	}
	
	
	@PostMapping(path = BASE_PATH_2, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			userDAO.create(user);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(user);
		}
		return ResponseEntity.ok(user);
//		return ResponseEntity.created(URI.create(BASE_PATH + "/" + seenMovies.getId())).build();

	}
	
	@PutMapping(path = BASE_PATH_2, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			userDAO.update(user);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(user);
		}
		return ResponseEntity.ok(user);
//		return ResponseEntity.created(URI.create(BASE_PATH + "/" + seenMovies.getId())).build();

	}
	
	@DeleteMapping(path = BASE_PATH_2 + "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	  void deleteUser(@PathVariable("id") Integer id) throws DataAccessException {
		User user = userDAO.getById(User.class, Integer.valueOf(id));
		userDAO.delete(user);
	  }

	
	
	
	
}