package com.ebibli.service;

import com.ebibli.dto.LivreDto;
import com.ebibli.mapper.LivreMapper;
import com.ebibli.mapper.UtilisateurMapper;
import com.ebibli.repository.LivreRepository;
import com.ebibli.repository.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class LivreService {

    private static final LivreMapper LIVRE_MAPPER = Mappers.getMapper(LivreMapper.class);
    private static final UtilisateurMapper UTILISATEUR_MAPPER = Mappers.getMapper(UtilisateurMapper.class);

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<LivreDto> getAllLivres() {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAll());
    }

    public List<LivreDto> getAllLivresDispo() {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAllByDisponibleTrue());
    }

    public List<LivreDto> getEmpruntsByUser(Integer userId) {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAllByEmprunteurId(userId));
    }

    public LivreDto returnLivre(Integer bibliothequeId, Integer livreId) {
        LivreDto livre = LIVRE_MAPPER.map(livreRepository.findById(livreId).get());
        if(livre.getBibliotheque().getId() != bibliothequeId) {
            return null;
        }
        livre.setDateEmprunt(null);
        livre.setDateRetourPrevu(null);
        livre.setProlonge(null);
        livre.setEmprunteur(null);
        livre.setDisponible(true);
        return LIVRE_MAPPER.map(livreRepository.save(LIVRE_MAPPER.map(livre)));
    }

    public LivreDto takeLivre(Integer emprunteurId, Integer livreId) {
        LivreDto livre = LIVRE_MAPPER.map(livreRepository.findById(livreId).get());
        livre.setDateEmprunt(Date.valueOf(LocalDate.now()));
        livre.setDateRetourPrevu(Date.valueOf(LocalDate.now().plusWeeks(4)));
        livre.setProlonge(false);
        livre.setEmprunteur(UTILISATEUR_MAPPER.map(utilisateurRepository.findById(emprunteurId).get()));
        livre.setDisponible(false);
        return LIVRE_MAPPER.map(livreRepository.save(LIVRE_MAPPER.map(livre)));
    }

    public LivreDto getLivre(int id) {
        return LIVRE_MAPPER.map(livreRepository.getOne(id));
    }

    public List<LivreDto> getLivresByBibliotheque(Integer id) {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAllByBibliotheque_IdOrderByOuvrageAsc(id));
    }

    public LivreDto upgradePret(Integer livreId) {
        LivreDto livre = LIVRE_MAPPER.map(livreRepository.findById(livreId).get());
        if(livre.getProlonge() == true) {
            return LIVRE_MAPPER.map(livreRepository.getOne(livreId));
        }
        livre.setDateRetourPrevu(Date.valueOf(livre.getDateRetourPrevu().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusWeeks(4)));
        livre.setProlonge(true);
        return LIVRE_MAPPER.map(livreRepository.save(LIVRE_MAPPER.map(livre)));
    }
}
