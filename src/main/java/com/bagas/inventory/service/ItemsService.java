/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bagas.inventory.service;

import com.bagas.inventory.dto.ItemsDto;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ItemsService {
    
    List<ItemsDto> getAllItems();
    
    ItemsDto getItemById(Long id);
    
    void saveItem(ItemsDto itemsDto);
    
    void updateItem(ItemsDto itemsDto);
    
    void deleteItem(Long id);
}
