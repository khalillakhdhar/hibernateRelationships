package com.duranco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.duranco.exception.RessourceNotFoundException;
import com.duranco.manytoone.Post;
import com.duranco.repositories.PostRepository;

@RestController
public class PostController {
@Autowired
private PostRepository postRepository;
@GetMapping("/posts")
public Page<Post> getAllPosts(Pageable pageable) {
return postRepository.findAll(pageable);
// pour afficher un nombre d'éléments (liste avec pagination)
}
@PostMapping("/posts")
public Post createPost(@Valid @RequestBody Post post) {
return postRepository.save(post);
}

@DeleteMapping("/posts/{postId}")
public ResponseEntity<?> deletePost(@PathVariable Long postId) {
//	Post post=postRepository.findById(postId).get(); // chargement unitile
//	if(!postRepository.findById(postId).isEmpty())
//	{
//		// traitement1
//		postRepository.delete(post); // delete par objet
//		return ResponseEntity.ok().build();
//	}
//	else
//	{
//		new RessourceNotFoundException("PostId " + postId + "not found"));
//		
//	}
//	
	return postRepository.findById(postId).map(post -> {
		// si l'élément existe => faire
		// -> arrow function => post= le résultat de findById
		postRepository.delete(post); // delete par objet
		return ResponseEntity.ok().build();
	}).orElseThrow(
			// si l'élément n'existe pas
			() -> new RessourceNotFoundException("PostId " + postId + "not found"));
}
}