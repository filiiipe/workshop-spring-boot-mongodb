package com.luizfilipe.workshopmongo.services;

import com.luizfilipe.workshopmongo.domain.User;
import com.luizfilipe.workshopmongo.dto.UserDTO;
import com.luizfilipe.workshopmongo.repository.UserRepository;
import com.luizfilipe.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public User insert(User obj){
    return repository.insert(obj);
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
