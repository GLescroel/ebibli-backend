package com.ebibli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @ManyToOne
    @NotNull
    private Ouvrage ouvrage;

    @ManyToOne
    @NotNull
    private Bibliotheque bibliotheque;

    @Basic
    private Boolean disponible;

    @ManyToOne
    private Utilisateur emprunteur;

    @Basic
    private Date dateEmprunt;

    @Basic
    private Date dateRetourPrevu;

    @Basic
    private Boolean prolonge;
}
