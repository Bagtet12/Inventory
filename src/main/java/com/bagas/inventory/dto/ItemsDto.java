/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagas.inventory.dto;

import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDto {
    private Long id;
    @NotEmpty(message = "Please Enter Valid Item Name")
    private String namaBarang;
    @NotEmpty(message = "Please Enter Valid Item Description")    
    private String deskripsi;
    @NotEmpty(message = "Please Enter Valid Stock")
    private Integer stok;
    @NotEmpty(message = "Please Enter Valid Price")
    private BigDecimal totalHarga;
    @NotEmpty(message = "Please Enter Valid Category")
    private Long categoryId;

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
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
