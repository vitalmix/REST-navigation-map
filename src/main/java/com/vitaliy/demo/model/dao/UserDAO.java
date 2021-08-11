package com.vitaliy.demo.model.dao;

import com.vitaliy.demo.model.entity.Place;

import java.util.List;

public interface UserDAO {

    public List<Place> searchPlaces(String query);

}
