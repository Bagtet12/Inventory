/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.controller;

import com.bagas.inventory.dto.CategoryDto;
import com.bagas.inventory.service.CategoryService;
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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> showItems() {
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveItem(@ModelAttribute("item") CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok("Add Category Succesfully");
    }

    @PutMapping("/save/edit/{id}")
    public ResponseEntity<CategoryDto>postEditItemForm(@PathVariable Long id, CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryService.updateCategory(categoryDto);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete Category Succesfully");
    }
    
}
