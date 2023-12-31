package com.dsm.up.domain.post.domain.repository;

import com.dsm.up.domain.post.domain.Post;
import com.dsm.up.domain.post.domain.type.MajorType;
import com.dsm.up.domain.post.domain.type.StateType;
import com.dsm.up.domain.user.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    Page<Post> findAllByTitleContainingOrderByIdDesc(String title, Pageable pageable);
    Page<Post> findAllByStateAndTitleContainingOrderByIdDesc(StateType state, String title, Pageable pageable);
    Page<Post> findAllByTitleContainingAndMajorOrderByIdDesc(String title, MajorType major, Pageable pageable);
    Page<Post> findAllByStateAndTitleContainingAndMajorOrderByIdDesc(StateType state, String title, MajorType major, Pageable pageable);
    Page<Post> findAllByUserOrderByIdDesc(User user, Pageable pageable);
    long countByUser(User user);
}
