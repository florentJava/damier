package com.example.damierenfx;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Case extends Parent {
    private Color couleur;
    private Coordonées posiotionCase;
    private boolean contient;
    private Pion pionCasa;

    public Case(Color couleur,Coordonées posiotionCase) {
        this.couleur = couleur;
        this.posiotionCase = posiotionCase;
        this.drawnCase();
        this.pionCasa = null;

    }

    public void drawnCase(){

        Rectangle rect=new Rectangle(); //instantiatin

        rect.setX(0); //setting the X coordinate of upper left //corner of rectangle
        rect.setY(0); //setting the Y coordinate of upper left //corner of rectangle
        rect.setWidth(60); //setting the width of rectangle
        rect.setHeight(60); // setting the height of rectangle
        rect.setStroke(Color.GREEN);
        rect.setFill(couleur);
        rect.setEffect( new DropShadow());

        this.getChildren().add(rect); //adding the class object //to the group

    }

    public void putPion(Pion pion){
        this.pionCasa = pion;
        this.getChildren().addAll(this.pionCasa);
        this.contient = true;
    }

    public Pion removePion(Pion pion){
        Pion p = this.pionCasa;
         this.getChildren().remove(this.pionCasa);
         this.contient=false;
         return p;
    }



    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Coordonées getPosiotionCase() {
        return posiotionCase;
    }

    public void setPosiotionCase(Coordonées posiotionCase) {
        this.posiotionCase = posiotionCase;
    }

    public boolean isContient() {
        return contient;
    }

    public void setContient(boolean contient) {
        this.contient = contient;
    }

    public Pion getPionCasa() {
        return pionCasa;
    }

    public void setPionCasa(Pion pionCasa) {
        this.pionCasa = pionCasa;
    }
}
