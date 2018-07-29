package com.spring.boot.repository;

/**
 * Created by mint on 7/29/18.
 */


import com.spring.boot.entity.City;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CityRepository extends Repository<City, Long> {

    List<City> findAll();

    City findByNameAndCountryAllIgnoringCase(String name, String country);

}

