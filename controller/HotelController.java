package com.lcw.hotel.controller;


import com.lcw.hotel.entity.Hotel;
import com.lcw.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> all = hotelService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);

    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> get(@PathVariable String hotelId){
        Hotel byId = hotelService.get(hotelId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

}
