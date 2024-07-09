package org.weatherapi40fs1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weatherapi40fs1.entity.WeatherDataEntity;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherDataEntity, Integer> {
    Optional<WeatherDataEntity> findByLatitudeAndLongitude (String lat, String lon);
}
