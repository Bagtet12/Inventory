/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
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
@Table(name = "items")
public class Items {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @Column(nullable = false)
    private String namaBarang;
    
    @Column(nullable = false)
    private String deskripsi;
        
    @Column(nullable = false)
    private Integer stok;
    
    @Column(nullable = false)
    private BigDecimal totalHarga;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    public Items (String namaBarang, String deskripsi, Integer stok, BigDecimal totalHarga, Category category) {
        this.namaBarang = namaBarang;
        this.deskripsi = deskripsi;
        this.stok = stok;
        this.totalHarga = totalHarga;
        this.category = category;
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
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * @return the stok
     */
    public Integer getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(Integer stok) {
        this.stok = stok;
    }

    /**
     * @return the totalHarga
     */
    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    /**
     * @param totalHarga the totalHarga to set
     */
    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    
}
