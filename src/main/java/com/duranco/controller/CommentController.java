package com.duranco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duranco.manytoone.Comment;
import com.duranco.manytoone.Post;
import com.duranco.repositories.CommentRepository;
import com.duranco.repositories.PostRepository;

@RestController
public class CommentController {
@Autowired
private CommentRepository commentRepository;
@Autowired
private PostRepository postRepository;
@GetMapping("/posts/{postId}/comments")
public Page<Comment> getCommentByPostId(@PathVariable long postId, Pageable pageable)

{
	return commentRepository.findByPostId(postId, pageable);
	
}
@PostMapping("/posts/{postId}/comments")
public Comment commenter(@PathVariable long postId,@RequestBody Comment comment)
{
	Post p=postRepository.findById(postId).get();
	comment.setPost(p);
	return commentRepository.save(comment);
}
@DeleteMapping("comment/{id}")
public void delete(@PathVariable long id)
{
commentRepository.deleteById(id);	
}

}
