package com.ebibli.service;

import com.ebibli.dto.LivreDto;
import com.ebibli.mapper.LivreMapper;
import com.ebibli.repository.LivreRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private static final LivreMapper LIVRE_MAPPER = Mappers.getMapper(LivreMapper.class);

    @Autowired
    private LivreRepository livreRepository;

    public List<LivreDto> getAllLivres() {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAll());
    }

    public List<LivreDto> getAllLivresDispo() {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAllByDisponibleTrue());
    }

    public List<LivreDto> getEmpruntsByUser(Integer userId) {
        return LIVRE_MAPPER.livresToLivreDtos(livreRepository.findAllByEmprunteurId(userId));
    }
}
