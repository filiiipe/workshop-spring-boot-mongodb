package com.luizfilipe.workshopmongo.resources;

import com.luizfilipe.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User test = new User(1L, "Jason", "jason@gmail.com");
        User test1 = new User(2L, "Jacob", "jacob@gmail.com");
        List<   User> list = new ArrayList<>(Arrays.asList(test, test1));
        return ResponseEntity.ok().body(list);
    }
}
