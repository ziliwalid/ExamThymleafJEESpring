package com.example.examthymleaf.Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_Livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;
    private String auteur;
    private String Titre;
    private String Domaine;
    private int nb_exemplaire;
    private String date;



}
