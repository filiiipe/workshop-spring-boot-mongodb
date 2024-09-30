package com.luizfilipe.workshopmongo.services;

import com.luizfilipe.workshopmongo.domain.Post;
import com.luizfilipe.workshopmongo.repository.PostRepository;
import com.luizfilipe.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
