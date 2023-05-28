package com.example.damierenfx;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Controler extends Parent {
    private Grille grille = new Grille();
    private boolean clickDeja;
    private Coordonées doné = null;
   private int betweenx,betweeny;

    private Joueur j1;
    private Joueur j2;


    public Controler() {
        this.j1 = new Joueur("florent",0, Color.BROWN);
        this.j2 = new Joueur("Arian",6, Color.BEIGE);
        this.addPion();
        this.clickDeja =false;
        testMouseClicked();
        this.getChildren().add(grille);

    }

    public void addPion(){
        String mat;
        for (int i =0;i<10;i++){
            for (int j =0;j<10;j++){
                if(i%2==j%2&&j<4){
                    mat = i+""+j;
                    grille.getLesCases()[i][j].putPion(j1.recherchePion(i+""+j));
                    j1.recherchePion(i+""+j).setCasePion(grille.getLesCases()[i][j]);
                } else if (i%2==j%2&&j>5) {
                    mat = i+""+j;
                    grille.getLesCases()[i][j].putPion(j2.recherchePion(mat));
                    j2.recherchePion(i+""+j).setCasePion(grille.getLesCases()[i][j]);


                }
            }
        }
    }

    public void testMouseClicked(){
        for (int i =0;i<10;i++){

            for (int j =0;j<10;j++){

                final int a,b;
                a=i;b=j;
                grille.getLesCases()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {

                        if (clickDeja&&!(grille.getLesCases()[a][b].isContient())) {

                            grille.getLesCases()[doné.getX()][doné.getY()].getPionCasa().setPositionPion(doné, grille.getLesCases()[a][b]);

                            if(Objects.equals(grille.getLesCases()[doné.getX()][doné.getY()].getPionCasa().getProprioPion().getNom(), "Arian") &&b==0){
                                grille.getLesCases()[doné.getX()][doné.getY()].getPionCasa().drawnCourone();

                            } else if (Objects.equals(grille.getLesCases()[doné.getX()][doné.getY()].getPionCasa().getProprioPion().getNom(), "florent") &&b==9) {
                                grille.getLesCases()[doné.getX()][doné.getY()].getPionCasa().drawnCourone();
                            }

                            grille.getLesCases()[doné.getX()][doné.getY()].setContient(false);
                            grille.getLesCases()[a][b].setContient(true);
                            clickDeja = !clickDeja;

                            if((a-doné.getX()==2||doné.getX()-a==2)&&(b-doné.getY()==2||doné.getY()-b==2)){
                                System.out.println("remove debut");

                                betweenx=(a+doné.getX())/2;
                                betweeny = (b+doné.getY())/2;
                                grille.getLesCases()[betweenx][betweeny].removePion(grille.getLesCases()[betweenx][betweeny].getPionCasa());

                                System.out.println("remove fin");

                            }



                        }else if(!(clickDeja)&&grille.getLesCases()[a][b].isContient()) {

                            clickDeja = !clickDeja;
                            doné = new Coordonées(a, b);
                        }else if (clickDeja&&(grille.getLesCases()[a][b].isContient())&&(doné.getX()==a&&doné.getY()==b)){
                            clickDeja = !clickDeja;
                        }

                    }



                });
            }
        }

    }
}
