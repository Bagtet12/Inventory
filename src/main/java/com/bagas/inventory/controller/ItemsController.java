/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.controller;

import com.bagas.inventory.dto.CategoryDto;
import com.bagas.inventory.dto.ItemsDto;
import com.bagas.inventory.model.Category;
import com.bagas.inventory.service.CategoryService;
import com.bagas.inventory.service.ItemsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    
    @Autowired
    private ItemsService itemsService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/list")
    public ResponseEntity<List<ItemsDto>> showItems() {
        List<ItemsDto> itemsList = itemsService.getAllItems();
        return ResponseEntity.ok(itemsList);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveItem(ItemsDto itemsDto) {
        itemsService.saveItem(itemsDto);
        return ResponseEntity.ok("Add Item Successfully");
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<ItemsDto> editItemForm(@PathVariable Long id) {
        ItemsDto itemsDto = itemsService.getItemById(id);
        return ResponseEntity.ok(itemsDto);
    }

    @PutMapping("/save/edit/{id}")
    public ResponseEntity<ItemsDto> postEditItemForm(@PathVariable Long id, ItemsDto itemsDto) {
        itemsDto.setId(id);
        itemsService.updateItem(itemsDto);
        return ResponseEntity.ok(itemsDto);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemsService.deleteItem(id);
        return ResponseEntity.ok("Delete item Succesfully");
    }
    
}
