package com.paul.ecommerce.dao;

import com.paul.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@RepositoryRestResource(
        path = "countries", collectionResourceRel = "country"
)
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
