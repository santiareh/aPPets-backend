package com.dailygit.todo.controllers;

import com.dailygit.todo.Repository.PetRepository;
import com.dailygit.todo.models.PetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    public PetRepository petRepository;

    @GetMapping("all")
    public List<PetModel> Index(@RequestParam String userID) {
        Sort sort = Sort.by("timestamp").descending();

        return petRepository.findAllByuserID(userID, sort);
    }

    @PostMapping("create")
    public PetModel Create(@RequestBody PetModel data) {

        PetModel newTask = new PetModel(data.getName(), data.getRace(), data.getType(), data.getContent(), data.getUserID());

        petRepository.save(newTask);

        return newTask;

    }

    @GetMapping("id")
    public Optional<PetModel> id(@RequestParam String id) {
        return petRepository.findById(id);
    }

    @PostMapping("update")
    public String Update(@RequestBody PetModel data) {

        petRepository.save(data);

        return "Pet Updated";
    }

    @DeleteMapping("delete")
    public String Delete(@RequestBody PetModel data) {

        petRepository.deleteById(data.getId());

        return "Pet Deleted";
    }

}


