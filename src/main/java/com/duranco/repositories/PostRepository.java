package com.duranco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duranco.manytoone.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
