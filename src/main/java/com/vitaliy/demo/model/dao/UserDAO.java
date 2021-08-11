package com.vitaliy.demo.model.dao;

import com.vitaliy.demo.model.entity.Place;
import com.vitaliy.demo.model.entity.User;

import java.util.List;

public interface UserDAO {

    public List<Place> searchPlaces(String query);

    public String getCurrentLoggedUsername();

    public User getCurrentLoggedUser();

}
