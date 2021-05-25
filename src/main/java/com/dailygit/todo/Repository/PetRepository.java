package com.dailygit.todo.Repository;

import com.dailygit.todo.models.PetModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetRepository extends MongoRepository<PetModel, String> {
    public List< PetModel > findAllByuserID(String userID, Sort sort);
}