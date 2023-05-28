package com.example.damierenfx;

import javafx.scene.paint.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Joueur {

    private Color couleur;
    private ArrayList<Pion> listePion;
    private String nom;
    private int debut;

    public Joueur(String nom,int debut,Color couleur) {
        this.listePion = new ArrayList<Pion>();
        this.debut = debut;
        this.nom = nom;
        this.couleur =couleur;
        initListePion();
    }
    public void initListePion(){
        for(int i=0;i<10;i++){
            for (int j=debut;j<=debut+3;j++) {
                if(i%2==j%2)
                    listePion.add( new Pion(new Coordonées(i,j),couleur,i+""+j,this));
            }
        }
    }

    public Pion recherchePion(String matricule){
        for (Pion p: listePion) {
            if(Objects.equals(p.getMatricule(), matricule)) {
                return  p;
            }
        }
        return null;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public ArrayList<Pion> getListePion() {
        return listePion;
    }

    public void setListePion(ArrayList<Pion> listePion) {
        this.listePion = listePion;
    }
}
