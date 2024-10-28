package com.dev.nistha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @GetMapping("/detail")
    public String getHotel() {
        return "Radisson Blu";
    }

    @GetMapping
    public List<Map<String, String>> listHotels() {
        List<Map<String, String>> hotels = new ArrayList<>();

        hotels.add(Map.of("name", "Radisson Blu"));


        return hotels;
    }

}
