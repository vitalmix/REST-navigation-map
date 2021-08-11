package com.vitaliy.demo.model.service;

import com.vitaliy.demo.model.entity.Place;
import com.vitaliy.demo.model.entity.User;

import java.util.List;

public interface UserService {

    public List<Place> searchPlaces(String query);

    public String getCurrentLoggedUsername();

    public User getCurrentLoggedUser();
}
