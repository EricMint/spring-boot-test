package com.spring.main.controller;

import com.spring.data.entity.City;
import com.spring.data.entity.User;
import com.spring.data.repository.CityRepository;
import com.spring.data.repository.TestService;
import com.spring.data.service.UserService;
import com.spring.data.util.HMAC;
import com.spring.main.TestProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TestService testService;

    @Autowired
    private TestProperties testProperties;

    @Autowired
    private UserService userService;

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

        String username = "testUsername";
        String password = "testPassword";
//        createUser(username, password);
        login(username, password);

        return cityList.toString();
    }

    private void createUser(String username, String password) {
        logger.info("Create user, username: {}, password: {}", username, password);
        userService.create(username, password, RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(5) + "@test.com");
    }

    private Boolean login(String username, String password) {
        logger.info("User login by using username: {}, password: {}", username, password);
        User user = userService.findOneByUsername(username);
        Boolean loginResult = user.getPasswordHash().equals(HMAC.hash(user.getSalt(), password));
        logger.info("Login result: {}", loginResult);
        return loginResult;
    }

}
