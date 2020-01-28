package br.com.edicarlosbarbosa.springpdf.service;

import br.com.edicarlosbarbosa.springpdf.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
}
