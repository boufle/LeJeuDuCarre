import java.util.ArrayList;

/**
 * Created by theobeaudenon on 29/05/2017.
 */

class GameInstance {

    int carreX = 5;
    int carreY = 5;

    Carre[][] plateau= new Carre[carreX][carreY];

    public GameInstance() {

        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){
               Cote gauche =  new Cote();
               Cote haut =  new Cote();
                if(i != 0){
                   gauche= plateau[i-1][z].getDroite(); // Renvoi le coté de gauche
                }
                if(z != 0){
                    haut= plateau[i][z-1].getBas(); // Renvoi le coté du haut
                }

                plateau[i][z] = new Carre(haut,new Cote(),new Cote(),gauche);
            }
        }


        int i = 0;

    }


    public ArrayList<Carre> getCarreFromCote(Cote cote){
        ArrayList<Carre> carreArrayList = new ArrayList<>();
        for (int i=0 ; i< carreX; i++){
            for(int z =0; z < carreY; z++){

                if(plateau[i][z].haut.equals(cote) ||plateau[i][z].bas.equals(cote) ||plateau[i][z].gauche.equals(cote) ||plateau[i][z].droite.equals(cote) ){
                    carreArrayList.add(plateau[i][z]) ;
                }

            }
        }
        return carreArrayList;
    }



}
