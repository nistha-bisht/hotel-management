package com.dev.nistha.service;

import com.dev.nistha.dto.RoomDTO;
import com.dev.nistha.errorhandler.NoRoomFoundException;

import java.util.List;

public interface RoomService {

    RoomDTO getRoomById(Long id) throws NoRoomFoundException;
    List<RoomDTO> getRooms();
    RoomDTO createRoom(RoomDTO roomDTO);
    RoomDTO updateRoom(RoomDTO roomDTO) throws NoRoomFoundException;
    void deleteRoom(Long id);

}
