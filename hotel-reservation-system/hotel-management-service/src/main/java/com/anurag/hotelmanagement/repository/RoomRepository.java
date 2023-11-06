package com.anurag.hotelmanagement.repository;

import com.anurag.hotelmanagement.entity.Hotel;
import com.anurag.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByHotelIdAndRoomNumber(Long id, Long roomNumber);
}
