package com.spring.data.repository;

import com.spring.data.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mint on 7/29/18.
 */

@Repository
public class CityRepositoryImpl extends BaseRepository implements CityRepository {

    @Override
    public List<City> findAll() {
        return this.entityManager.createQuery("select c from City c", City.class).getResultList();
    }

    @Override
    public City findByNameAndCountryAllIgnoringCase(String name, String country) {
        return null;
    }
}
