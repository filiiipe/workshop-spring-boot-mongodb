package com.luizfilipe.workshopmongo.services.exception;

import com.luizfilipe.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
