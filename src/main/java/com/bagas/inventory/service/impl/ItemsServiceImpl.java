/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.service.impl;

import com.bagas.inventory.dto.ItemsDto;
import com.bagas.inventory.model.Category;
import com.bagas.inventory.model.Items;
import com.bagas.inventory.repository.CategoryRepository;
import com.bagas.inventory.repository.ItemsRepository;
import com.bagas.inventory.service.ItemsService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    @Override
    public List<ItemsDto> getAllItems() {
        List<Items> itemsList = itemsRepository.findAll();
        return itemsList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemsDto getItemById(Long id) {
        Items items = itemsRepository.findById(id).orElse(null);
        return convertToDTO(items);
    }

    @Override
    public void saveItem(ItemsDto itemsDto) {
        
        Category category = categoryRepository.findById(itemsDto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found id: " + itemsDto.getCategoryId()));
    
        Items items = new Items();
        items.setNamaBarang(itemsDto.getNamaBarang());
        items.setDeskripsi(itemsDto.getDeskripsi());
        items.setStok(itemsDto.getStok());
        items.setTotalHarga(itemsDto.getTotalHarga());
        items.setCategory(category);
        items = itemsRepository.save(items);

    }

    @Override
    public void deleteItem(Long id) {
        itemsRepository.deleteById(id);
    }

    private ItemsDto convertToDTO(Items items) {
        ItemsDto itemsDto = new ItemsDto();
        itemsDto.setId(items.getId());
        itemsDto.setNamaBarang(items.getNamaBarang());
        itemsDto.setDeskripsi(items.getDeskripsi());
        itemsDto.setStok(items.getStok());
        itemsDto.setTotalHarga(items.getTotalHarga());
        itemsDto.setCategoryId(items.getCategory().getId());
        return itemsDto;
    }

    @Override
    public void updateItem(ItemsDto itemsDto) {
        Items items = itemsRepository.findById(itemsDto.getId()).orElseThrow(() -> new EntityNotFoundException("Category not found id: " + itemsDto.getId()));
        
        Category category = categoryRepository.findById(itemsDto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found id: " + itemsDto.getCategoryId()));
    
        items.setNamaBarang(itemsDto.getNamaBarang());
        items.setDeskripsi(itemsDto.getDeskripsi());
        items.setStok(itemsDto.getStok());
        items.setTotalHarga(itemsDto.getTotalHarga());
        items.setCategory(category);
        items = itemsRepository.save(items);
    }
    
}
