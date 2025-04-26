package com.example.scrap_app.service;


import com.example.scrap_app.exception.UserNotFoundException;
import com.example.scrap_app.model.UserModel;
import com.example.scrap_app.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAll() {

        List data = new ArrayList();

        try {
            data = userRepository.findAll();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void create(@Valid UserModel user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Błąd podczas zapisu użytkownika", e);
        }
    }

    public void delete(String id) {
//        if(!userRepository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Nie znaleziono użytkownika");
//        }
//
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Użytkownik z ID:" + id + " nie istnieje"));

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Błąd podczas usuwania użytkownika", e);
        }


    }

    public UserModel getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

}
