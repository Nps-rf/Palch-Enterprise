package com.example.t_24.Service;

import java.util.List;

import com.example.t_24.Entity.Cargo;
import com.example.t_24.Repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    @Autowired
    private CargoRepository repo;

    //Поиск и фильтр
    public List<Cargo> listAll(String keyword, String departureDate) {
        if (keyword != null && departureDate != null) {
            return repo.searchByKeywordAndDepartureDate(keyword, departureDate);
        } else if (keyword != null) {
            return repo.searchByKeyword(keyword);
        } else if (departureDate != null) {
            return repo.filterByDepartureDate(departureDate);
        } else {
            return repo.findAll();
        }
    }

    public void save(Cargo cargo){
        repo.save(cargo);
    }

    public Cargo get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
