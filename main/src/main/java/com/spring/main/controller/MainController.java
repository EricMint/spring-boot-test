package com.spring.main.controller;

import com.spring.data.entity.City;
import com.spring.data.repository.CityRepository;
import com.spring.data.repository.TestService;
import com.spring.main.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private TestProperties testProperties;

    @Value("${environment}")
    private String environment;


    @GetMapping("/")
    @Transactional
    public String test() {
        String message = testService.message();
        System.out.println(message);
        List<City> cityList = cityRepository.findAll();
        for (City city : cityList) {
            System.out.println(city.toString());
        }

        System.out.println("testProperties: " + testProperties);
        System.out.println("Current environment: " + environment);

        return cityList.toString();
    }


}
