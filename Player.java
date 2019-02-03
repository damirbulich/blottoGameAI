import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Player{
    private List<Kula> strategija = new ArrayList<>();

    void addKule(int brKula){
        for (int i=0;i<brKula;i++){
            strategija.add(new Kula(10));
        }
    }
    void addVojnici(int brKule,int brVojnika){
        strategija.get(brKule).putVojnici(brVojnika);
    }
}