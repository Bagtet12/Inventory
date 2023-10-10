/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @Column(nullable = false)
    private String kategori;
    @Column(nullable = false)
    private String nomorSeri;
    
    
    @OneToMany(mappedBy = "category")
    private Set<Items> items;
    
    public Category (String kategori, String nomorSeri) {
        this.kategori = kategori;
        this.nomorSeri = nomorSeri;
    }

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

    /**
     * @return the items
     */
    public Set<Items> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<Items> items) {
        this.items = items;
    }

    
    
}
