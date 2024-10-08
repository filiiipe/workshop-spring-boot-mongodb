package com.luizfilipe.workshopmongo.resources;

import com.luizfilipe.workshopmongo.domain.Post;
import com.luizfilipe.workshopmongo.domain.User;
import com.luizfilipe.workshopmongo.dto.UserDTO;
import com.luizfilipe.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
        User user = service.fromDTO(userDTO);
        user.setId(id);
        user = service.update(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}