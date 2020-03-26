package com.ebibli.controller;

import com.ebibli.dto.UtilisateurDto;
import com.ebibli.model.Utilisateur;
import com.ebibli.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UtilisateurController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(value = "/Utilisateurs")
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        return new ResponseEntity<>(utilisateurService.getAllUsers(), HttpStatus.OK);
    }

    //TODO revoir le code si non trouvé et le gérer côté front
    @GetMapping(value = "/Utilisateur/{email}")
    public ResponseEntity<UtilisateurDto> checkIfUserExists(@PathVariable("email") String email) {
        LOGGER.info("Dans LoginController - checkIfUserExists(" + email + ")");
        UtilisateurDto utilisateur = utilisateurService.getUserByEmail(email);
        if(utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/Utilisateur/creation")
    public ResponseEntity<Void> addUser(@RequestBody UtilisateurDto utilisateur) {
        LOGGER.info("Dans LoginController - addUser");
        if (utilisateur == null) {
            return ResponseEntity.noContent().build();
        }
        UtilisateurDto newUtilisateur = utilisateurService.save(utilisateur);
        if (newUtilisateur != null) {
            return ResponseEntity.created(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newUtilisateur.getId())
                    .toUri())
                    .build();
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/Utilisateur/suppression")
    public ResponseEntity<Void> deleteUser(@RequestBody UtilisateurDto utilisateur) {
        LOGGER.info("Dans LoginController - deleteUser");
        utilisateurService.delete(utilisateur);
        return ResponseEntity.ok().build();
    }
}
