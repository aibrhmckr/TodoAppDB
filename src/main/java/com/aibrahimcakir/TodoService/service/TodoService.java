package com.aibrahimcakir.TodoService.service;

import com.aibrahimcakir.TodoService.model.Todo;
import com.aibrahimcakir.TodoService.model.User;
import com.aibrahimcakir.TodoService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final UserRepository userRepository;//mongo db için kullanılıyor user classı bağlandı//
    // aynısını To do sınıfı içinde oluşturman gerekebilir
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);//id yi otomatik verir
    }

    public void deleteUser(String Id) {
        userRepository.deleteById(Id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }//email ile bualamam diye id ile bulma metodu ekledim
    public void updateUser(String id, User newName) {
        User oldUser = getUserById(id);
        oldUser.setName(newName.getName());
        userRepository.save(oldUser);
    }

    /*public Object createTodo(Todo newTodo) {
        return userRepository
    }*/
}
