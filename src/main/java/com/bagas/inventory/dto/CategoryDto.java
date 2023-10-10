/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    
    private Long id;
    @NotEmpty(message = "Please enter valid category")
    private String kategori;
    @NotEmpty(message = "Please enter valid Serial Number")
    private String nomorSeri;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the nomorSeri
     */
    public String getNomorSeri() {
        return nomorSeri;
    }

    /**
     * @param nomorSeri the nomorSeri to set
     */
    public void setNomorSeri(String nomorSeri) {
        this.nomorSeri = nomorSeri;
    }
    
}
