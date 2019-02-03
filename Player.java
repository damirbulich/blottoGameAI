import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Player{
    private List<Kula> strategija = new ArrayList<>();
    private int score = 0;

    void addKule(int brKula){
        for (int i=0;i<brKula;i++){
            this.strategija.add(new Kula(10));
        }
    }
    void addVojnici(int brKule,int brVojnika){
        this.strategija.get(brKule).putVojnici(brVojnika);
    }
    void addScore(int bod){
        this.score+=bod;
    }
    void calcRnStrategy(int ukBrVojnika){
        Random rn = new Random();
        int i;
        for(i=0;i<this.strategija.size()-1;i++){
            int tempVojnika = rn.nextInt(ukBrVojnika);
            this.strategija.get(i).putVojnici(tempVojnika);
            ukBrVojnika-=tempVojnika;
        }
        this.strategija.get(i).putVojnici(ukBrVojnika);
    }
    int getVojniciFromKula(int brKule){
        return this.strategija.get(brKule).getVojnici();
    }
    int getScore(){
        return this.score;
    }
    String getStrategija(){
        String strat="";
        for(int i=0;i<this.strategija.size();i++){
            strat+=(this.strategija.get(i).getVojnici()+" ");
        }
        return strat;
    }
}