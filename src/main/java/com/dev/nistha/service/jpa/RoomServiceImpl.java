package com.dev.nistha.service.jpa;

import com.dev.nistha.dto.RoomDTO;
import com.dev.nistha.entity.Room;
import com.dev.nistha.errorhandler.NoRoomFoundException;
import com.dev.nistha.mapper.RoomMapper;
import com.dev.nistha.repository.RoomRepository;
import com.dev.nistha.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDTO getRoomById(Long id) throws NoRoomFoundException {
        Optional<Room> savedRoom = roomRepository.findById(id);

        if (savedRoom.isEmpty())
            throw new NoRoomFoundException("No room found with id: " + id);

        return roomMapper.roomToRoomDTO(savedRoom.get());
    }

    @Override
    public List<RoomDTO> getRooms() {
        List<Room> savedRooms = roomRepository.findAllRooms();
        return savedRooms.stream().map(roomMapper::roomToRoomDTO).toList();
    }

    @Override
    @Transactional
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room savedRoom = roomRepository.save(roomMapper.roomDTOToRoom(roomDTO));
        return roomMapper.roomToRoomDTO(savedRoom);
    }

    @Override
    @Transactional
    public RoomDTO updateRoom(RoomDTO roomDTO) throws NoRoomFoundException {
        Optional<Room> existingRoom = roomRepository.findByRoomNumber(roomDTO.getRoomNumber());
        if (existingRoom.isEmpty())
            throw new NoRoomFoundException("No room found with room number: " + roomDTO.getRoomNumber());

        Room updatedRoom = roomRepository.save(roomMapper.roomDTOToRoom(roomDTO));
        return roomMapper.roomToRoomDTO(updatedRoom);
    }

    @Override
    @Transactional
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

}
