package com.spring.boot.controller;

import com.spring.boot.entity.City;
import com.spring.boot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mint on 7/29/18.
 */

@RestController
public class MainController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/")
    @Transactional
    public String test() {
        List<City> cityList = cityRepository.findAll();
        for (City city : cityList) {
            System.out.println(city.toString());
        }

        return cityList.toString();
    }

}
