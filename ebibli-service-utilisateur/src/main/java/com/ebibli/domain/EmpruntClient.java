package com.ebibli.domain;

import com.ebibli.dto.EmpruntDto;

import java.util.List;

public interface EmpruntClient {

    List<EmpruntDto> findEmpruntsEnCoursByUtilisateur(Integer userid);

    List<EmpruntDto> findEmpruntsTermineByUtilisateur(Integer userid);

    EmpruntDto suppressionEmprunteur(Integer empruntId);
}

