package com.rpggame.rpgbackend.controller;

import com.rpggame.rpgbackend.model.Item;
import com.rpggame.rpgbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/shop")
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

}
