import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Player{
    Random rn = new Random();
    private List<Kula> strategija = new ArrayList<>();
    private int score = 0;

    void addKule(int[] bodovanje){
        for (int i=0;i<bodovanje.length;i++){
            this.strategija.add(new Kula(bodovanje[i]));
        }
    }
    void addVojnici(int brKule,int brVojnika){
        this.strategija.get(brKule).putVojnici(brVojnika);
    }
    void resetScore(){
        this.score=0;
    }
    void addScore(int bod){
        this.score+=bod;
    }
    void calcRnStrategy(int ukBrVojnika){
        int i;
        for(i=0;i<this.strategija.size()-1;i++){
            int tempVojnika = rn.nextInt(ukBrVojnika);
            this.strategija.get(i).putVojnici(tempVojnika);
            ukBrVojnika-=tempVojnika;
        }
        this.strategija.get(i).putVojnici(ukBrVojnika);
        //Collections.shuffle(this.strategija);
    }
    void mutate(Player najbolji, int ukBrVojnika){
        int i;
        for(i=0;i<this.strategija.size()-1;i++){
            int tempVojnika = rn.nextInt(ukBrVojnika);
            this.strategija.get(i).putVojnici(tempVojnika);
            ukBrVojnika-=tempVojnika;
        }
        this.strategija.get(i).putVojnici(ukBrVojnika);
        //Collections.shuffle(this.strategija);
    }
    int getVojniciFromKula(int brKule){
        return this.strategija.get(brKule).getVojnici();
    }
    int getBodoviFromKula(int k){
        return this.strategija.get(k).getBodovi();
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