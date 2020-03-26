package com.ebibli.service;

import com.ebibli.dto.UtilisateurDto;
import com.ebibli.mapper.UtilisateurMapper;
import com.ebibli.model.Utilisateur;
import com.ebibli.repository.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private static final UtilisateurMapper UTILISATEUR_MAPPER = Mappers.getMapper(UtilisateurMapper.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public UtilisateurDto getUserByEmail(String email) {
        return UTILISATEUR_MAPPER.map(utilisateurRepository.findUtilisateurByEmail(email.toUpperCase()));
    }

    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return  UTILISATEUR_MAPPER.map(utilisateurRepository.save(UTILISATEUR_MAPPER.map(utilisateurDto)));
    }

    public boolean delete(UtilisateurDto utilisateurDto) {
        utilisateurRepository.delete(UTILISATEUR_MAPPER.map(utilisateurDto));
        return true;
    }
}
