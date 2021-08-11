package com.vitaliy.demo.model.dao.impl;

import com.vitaliy.demo.model.dao.UserDAO;
import com.vitaliy.demo.model.entity.Place;
import com.vitaliy.demo.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

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

    @Override
    public String getCurrentLoggedUsername() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }

    @Override
    public User getCurrentLoggedUser() {

        String username = getCurrentLoggedUsername();

        if(!username.equals("anonymousUser")) {

            Session currentSession = sessionFactory.getCurrentSession();

            User user = (User) currentSession.createQuery("from User u where u.username = '"+ username +"'").uniqueResult();

            return user;

        }

        return null;
    }
}
