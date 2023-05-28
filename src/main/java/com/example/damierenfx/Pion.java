package com.example.damierenfx;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pion extends Parent {

    private Coordonées positionPion;
    private Color couleur;
    private String matricule;
    private Joueur proprioPion;
    private Case casePion;


    public Pion(Coordonées positionPion, Color couleur, String matricule, Joueur proprioPion) {
        this.positionPion = positionPion;
        this.casePion = null;
        this.couleur = couleur;
        this.matricule = matricule;
        this.proprioPion = proprioPion;
        drawnPion();
    }

    public void drawnPion(){
        Circle circle = new Circle();
        circle.setCenterX(30);
        circle.setCenterY(30);
        circle.setRadius(25);
        circle.setFill(couleur);
        this.getChildren().addAll(circle);
    }

    public void drawnCourone(){
        Circle circle = new Circle();
        circle.setCenterX(30);
        circle.setCenterY(30);
        circle.setRadius(15);
        circle.setFill(Color.PINK);
        this.getChildren().addAll(circle);

    }


    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Coordonées getPositionPion() {
        return positionPion;
    }

    public void setPositionPion(Coordonées positionPion, Case newCase) {
        this.positionPion = positionPion;
        this.setCasePion(newCase);
        newCase.putPion(this);
    }

    public Joueur getProprioPion() {
        return proprioPion;
    }

    public void setProprioPion(Joueur proprioPion) {
        this.proprioPion = proprioPion;
    }

    public Case getCasePion() {
        return casePion;
    }

    public void setCasePion(Case casePion) {
        this.casePion = casePion;
    }
}
