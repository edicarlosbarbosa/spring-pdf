package br.com.edicarlosbarbosa.springpdf.controller;

import br.com.edicarlosbarbosa.springpdf.model.City;
import br.com.edicarlosbarbosa.springpdf.service.ICityService;
import br.com.edicarlosbarbosa.springpdf.util.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    private ICityService service;

    @RequestMapping(value = "pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {
        List<City> cities = service.findAll();
        ByteArrayInputStream byteArrayInputStream = GeneratePdfReport.citiesReport(cities);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=cities.pdf");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }

}
