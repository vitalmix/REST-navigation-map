package com.vitaliy.demo.control.rest;

import com.vitaliy.demo.model.entity.Place;
import com.vitaliy.demo.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchRestController {

    @Autowired
    UserService userService;

    @GetMapping("/searchPlace")
    public List<Place> searchPlace(@RequestParam ("searchedPlace") String searchedPlace) {

        List<Place> places = userService.searchPlaces(searchedPlace);

        if (!userService.getCurrentLoggedUsername().equals("anonymousUser")) {

            for (Place p :
                    places) {
                userService.saveSearchedPlace(p);
            }
        }

        return places;
    }

}
