package com.vitaliy.demo.model.service.impl;

import com.vitaliy.demo.model.dao.UserDAO;
import com.vitaliy.demo.model.entity.Place;
import com.vitaliy.demo.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<Place> searchPlaces(String query) {
        return userDAO.searchPlaces(query);
    }
}
