package com.luizfilipe.workshopmongo.resources;

import com.luizfilipe.workshopmongo.domain.User;
import com.luizfilipe.workshopmongo.dto.UserDTO;
import com.luizfilipe.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users =  service.findAll();
        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
