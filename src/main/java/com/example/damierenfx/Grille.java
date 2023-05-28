package com.example.damierenfx;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Grille extends Parent {

    private GridPane grille = new GridPane();
    private Case[][] lesCases = new Case[10][10];
    private Case uneCase = new Case(Color.BLACK,new Coordonées(0,0));

    public GridPane getGrille() {
        return grille;
    }

    public Case[][] getLesCases() {
        return lesCases;
    }
    public Grille(){
        drawnGrille();
        this.getChildren().add(new Label("jeux de damier"));
        this.getChildren().add(grille);
    }
    public void drawnGrille(){

        for(int i = 0; i<10; i++){
            for(int j =0;j<10;j++){

                if(i%2==j%2)
                    lesCases[i][j] = new Case((Color.rgb(162, 99, 2, 0.63)), new Coordonées(i,j));
                else
                    lesCases[i][j] = new Case((Color.rgb(140, 134, 121,0.63)),new Coordonées(i,j));

                grille.add(lesCases[i][j],i,j);
            }
        }

    }
}
