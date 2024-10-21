package com.dev.nistha.entity;

import com.dev.nistha.entity.constant.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;
    @Column(name = "room_no")
    private String roomNumber;
    @Column(name = "room_type")
    private RoomType roomType;
    @Column(name = "room_charges", precision = 10, scale = 2)
    private BigDecimal roomPrice;
    @Column(name = "no_of_beds")
    private Integer roomCapacity;
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

}
