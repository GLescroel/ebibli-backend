package com.ebibli.controller;

import com.ebibli.dto.BibliothequeDto;
import com.ebibli.service.BibliothequeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BibliothequeController.class);

    @Autowired
    private BibliothequeService bibliothequeService;

    @GetMapping(value = "/Bibliotheques")
    public ResponseEntity<List<BibliothequeDto>> getAllBibliotheques() {
        LOGGER.info("Dans BibliothequeController - getAllBibliotheques");
        return new ResponseEntity<>(bibliothequeService.getAllBibliotheques(), HttpStatus.OK);
    }
}
