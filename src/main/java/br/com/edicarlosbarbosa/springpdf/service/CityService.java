package br.com.edicarlosbarbosa.springpdf.service;

import br.com.edicarlosbarbosa.springpdf.model.City;
import br.com.edicarlosbarbosa.springpdf.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }
}
