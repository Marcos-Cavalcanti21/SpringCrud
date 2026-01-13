package com.spring.crud.service;

import com.spring.crud.model.User;
import com.spring.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User Save(User user) {
        return repository.save(user);
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public User SearchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));
    }

    public User Update(Long id, User user) {
        User Exist = SearchById(id);
        Exist.setName(user.getName());
        Exist.setEmail(user.getEmail());
        return repository.save(Exist);
    }

    public void delete(Long Id) {
        repository.deleteById(Id);
    }
}
