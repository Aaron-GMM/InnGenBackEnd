package com.InnGen.services;

import com.InnGen.models.User;
import com.InnGen.repositories.UserRepository;
import com.InnGen.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public  List<User> findAll(){return repository.findAll();}

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public User insert(User user){return repository.save(user);}

    public void delete(Long id){repository.deleteById(id);}

    public User update(User newuser){
        User user  = findById(newuser.getId());
        user.setNome(newuser.getNome());
        user.setLogin(newuser.getLogin());
        user.setSenha(newuser.getSenha());
    return repository.save(user);
    }

}
