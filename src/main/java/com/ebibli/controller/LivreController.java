package com.ebibli.controller;

import com.ebibli.dto.LivreDto;
import com.ebibli.service.LivreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LivreController.class);

    @Autowired
    private LivreService livreService;

    @GetMapping(value = "/Livres")
    public ResponseEntity<List<LivreDto>> getAllLivres() {
        LOGGER.info("Dans LivreController - getAllLivres");
        return new ResponseEntity<>(livreService.getAllLivres(), HttpStatus.OK);
    }

    @GetMapping(value = "/LivresDispo")
    public ResponseEntity<List<LivreDto>> getAllLivresDispo() {
        LOGGER.info("Dans LivreController - getAllLivresDispo");
        return new ResponseEntity<>(livreService.getAllLivresDispo(), HttpStatus.OK);
    }
}
