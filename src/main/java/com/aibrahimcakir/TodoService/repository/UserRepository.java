package com.aibrahimcakir.TodoService.repository;

import com.aibrahimcakir.TodoService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
