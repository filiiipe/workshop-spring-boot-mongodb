package com.luizfilipe.workshopmongo.repository;

import com.luizfilipe.workshopmongo.domain.Post;
import com.luizfilipe.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
