package com.vitaliy.demo.model.dao;

import com.vitaliy.demo.model.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    @Override
    public List<Place> searchPlaces(String query) {
        String url = "https://nominatim.openstreetmap.org/?addressdetails=1&q=" + query + "&format=json&limit=1";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Place>> rateResponse =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Place>>() {
                        });
        List<Place> places = rateResponse.getBody();

        return places;
    }
}