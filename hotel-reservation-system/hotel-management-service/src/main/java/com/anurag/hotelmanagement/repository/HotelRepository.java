package com.anurag.hotelmanagement.repository;

import com.anurag.hotelmanagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}
