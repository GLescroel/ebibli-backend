package com.ebibli.controller;

import com.ebibli.dto.LivreDto;
import com.ebibli.service.LivreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(value = "/Livre/{id}")
    public ResponseEntity<LivreDto> getLivre(@PathVariable ("id") Integer id) {
        LOGGER.info("Dans LivreController - getLivre");
        return new ResponseEntity<>(livreService.getLivre(id), HttpStatus.OK);
    }

    @GetMapping(value = "/Livres/{id}")
    public ResponseEntity<List<LivreDto>> getLivresByBibliotheque(@PathVariable ("id") Integer id) {
        LOGGER.info("Dans LivreController - getLivresByBibliotheque");
        return new ResponseEntity<>(livreService.getLivresByBibliotheque(id), HttpStatus.OK);
    }

    @PostMapping(value = "/emprunt/{livreId}/{emprunteurId}")
    public ResponseEntity<LivreDto> takeLivre(@PathVariable ("emprunteurId") Integer emprunteurId,
    @PathVariable ("livreId") Integer livreId) {
        LOGGER.info("Dans LivreController - takeLivre");
        return new ResponseEntity<>(livreService.takeLivre(emprunteurId, livreId), HttpStatus.OK);
    }

    @PostMapping(value = "/retour/{bibliothequeId}/{livreId}")
    public ResponseEntity<LivreDto> returnLivre(@PathVariable ("bibliothequeId") Integer bibliothequeId,
                                                     @PathVariable ("livreId") Integer livreId) {
        LOGGER.info("Dans LivreController - returnLivre");
        return new ResponseEntity<>(livreService.returnLivre(bibliothequeId, livreId), HttpStatus.OK);
    }
}
