/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.service.impl;

import com.bagas.inventory.dto.CategoryDto;
import com.bagas.inventory.model.Category;
import com.bagas.inventory.repository.CategoryRepository;
import com.bagas.inventory.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getKategori(),categoryDto.getNomorSeri());
        category = categoryRepository.save(category);
        return convertToDTO(category);
    }
    
    @Override
    public Category findKategoriByKategori(String kategori) {
        return categoryRepository.findByKategori(kategori);
    }
    
    private CategoryDto convertToDTO(Category category) {
        return new CategoryDto(category.getId(), category.getKategori(), category.getNomorSeri());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return convertToDTO(category);
        
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        Category categoryExist = categoryRepository.findById(categoryDto.getId()).orElseThrow(() -> new IllegalArgumentException("Category Id not found : " + categoryDto.getId()));
        categoryExist.setKategori(categoryDto.getKategori());
        categoryExist.setNomorSeri(categoryDto.getNomorSeri());
        
        categoryRepository.save(categoryExist);
    }
    
    
}
