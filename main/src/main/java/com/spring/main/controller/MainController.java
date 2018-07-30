package com.spring.main.controller;

import com.spring.data.entity.City;
import com.spring.data.repository.CityRepository;
import com.spring.data.repository.TestService;
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

    @Autowired
    private TestService testService;

    @GetMapping("/")
    @Transactional
    public String test() {
        String message = testService.message();
        System.out.println(message);
        List<City> cityList = cityRepository.findAll();
        for (City city : cityList) {
            System.out.println(city.toString());
        }

        return cityList.toString();
    }


}
