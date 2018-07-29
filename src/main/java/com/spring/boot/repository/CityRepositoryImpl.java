package com.spring.boot.repository;

import com.spring.boot.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mint on 7/29/18.
 */

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<City> findAll() {
        return this.entityManager.createQuery("select c from City c", City.class).getResultList();
    }

    @Override
    public City findByNameAndCountryAllIgnoringCase(String name, String country) {
        return null;
    }
}
