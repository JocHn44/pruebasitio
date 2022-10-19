package com.Interfaces;

import com.Models.producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Iproducto extends JpaRepository<producto, Long> {

}
