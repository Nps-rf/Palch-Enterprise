package com.example.t_24;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query("SELECT p FROM Cargo p WHERE CONCAT(p.v_name, '', p.content, '', p.dispatch_city, ''," +
            " p.departure_date,'', p.arrival_city, '', p.arrival_date) LIKE %?1%")
    List<Cargo> search(String keyword);
}
