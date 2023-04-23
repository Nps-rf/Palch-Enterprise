package com.example.t_24;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query("SELECT p FROM Cargo p WHERE CONCAT(p.v_name, '', p.content, '', p.dispatch_city, ''," +
           " p.departure_date,'', p.arrival_city, '', p.arrival_date) LIKE %?1%")
    List<Cargo> searchByKeyword(String keyword);

    @Query("SELECT p FROM Cargo p WHERE p.departure_date = ?1")
    List<Cargo> filterByDepartureDate(String departure_date);

    @Query("SELECT p FROM Cargo p WHERE CONCAT(p.v_name, '', p.content, '', p.dispatch_city, ''," +
           " p.departure_date,'', p.arrival_city, '', p.arrival_date) LIKE %?1% AND p.departure_date = ?2")
    List<Cargo> searchByKeywordAndDepartureDate(String keyword, String departure_date);
}
