package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long>  {
	// Fetch cars by brand
	List<Car> findByBrand(@Param("brand") String brand);

	// Fetch cars by color
	List<Car> findByColor(@Param("color") String color);

	// Fetch cars by year
	List<Car> findByYear(@Param("year") int year);

	// Fetch cars by year
	List<Car> findByBrandAndYear(@Param("brand") String brand, @Param("year") int year);

    @Query(value = "CALL simpleCar;", nativeQuery = true)
    List<Car> simpleCar();
}
