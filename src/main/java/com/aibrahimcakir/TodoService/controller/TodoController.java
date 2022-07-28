package com.aibrahimcakir.TodoService.controller;

import com.aibrahimcakir.TodoService.model.Todo;
import com.aibrahimcakir.TodoService.model.User;
import com.aibrahimcakir.TodoService.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/todo")//controller hangi urlde çalışacak
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {//kullanıcıları getirmek için aynısını todolar içinde yap
        return new ResponseEntity<>(todoService.getUsers(), OK);//bu metodları service içinde oluştur
    }

    @GetMapping("/{email}")//istenilen kullanıcıyı getiri
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return new ResponseEntity<>( getUserByEmail(email), OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return new ResponseEntity<>(todoService.createUser(newUser), CREATED);
    }
   /* @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        return new ResponseEntity<>(todoService.createTodo(newTodo),CREATED);
    }*/

    @PutMapping("/{id}")//aynısını görevler için de yap/ bu değiştirmeye yarıyo
    public ResponseEntity<Void> getTodo(@PathVariable String id,
                                        @RequestBody User newName
    ) {
        User oldUser = getUserById(id);
        //oldTodo.setTask(newTodo.getTask());
        oldUser.setName(newName.getName());
        todoService.updateUser(id, newName);
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/{Id}") //buda email ile kullanıcıyı siler
    public ResponseEntity<Void> deleteUser(@PathVariable String Id){
        todoService.deleteUser(Id);
        return new ResponseEntity<>(OK);
        //id ile kullanıcı siliniyor emaile çevirmeyi dene
    }
    private User getUserByEmail(String email) {
       return todoService.getUserByEmail(email);//getUserById metodu oluştur
    }
    private User getUserById(String id) {
        return todoService.getUserByEmail(id);//getUserById metodu oluştur
    }
    private Todo getTodoByEmail(User user, String taskId) {
        return user.getTodos().
                stream()
                .filter(todo -> todo.getTaskId().equals(taskId))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Todos not found"));
    }
}
