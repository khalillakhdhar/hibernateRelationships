package com.duranco.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.duranco.manytoone.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
Page<Comment> findByPostId(long postId,Pageable pageable);
Optional<Comment> findByIdAndPostId(long id,int postId);

}
