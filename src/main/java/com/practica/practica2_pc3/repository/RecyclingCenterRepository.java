package com.practica.practica2_pc3.repository;

import com.practica.practica2_pc3.model.RecyclingCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingCenterRepository extends JpaRepository<RecyclingCenter,Long> {

    Page<RecyclingCenter> findAllByStatus(Pageable pageable, String status);
}
