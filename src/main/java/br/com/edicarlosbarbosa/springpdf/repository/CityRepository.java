package br.com.edicarlosbarbosa.springpdf.repository;

import br.com.edicarlosbarbosa.springpdf.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
