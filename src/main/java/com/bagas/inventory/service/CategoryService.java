/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bagas.inventory.service;

import com.bagas.inventory.dto.CategoryDto;
import com.bagas.inventory.model.Category;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CategoryService {
    
    List<CategoryDto> getAllCategory();
    
    CategoryDto getCategoryById(Long id);
    
    CategoryDto saveCategory(CategoryDto categoryDto);
    
    void updateCategory(CategoryDto categoryDto);
    
    Category findKategoriByKategori(String kategori);
    
    void deleteCategory(Long id);
    
}
