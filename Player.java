import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Player{
    Random rn = new Random();
    private List<Kula> strategija = new ArrayList<>();
    private int score = 0;
    private int[] strat = new int[30];

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
    void calcRnStrategy(int ukVojnika){
        int i;
        int uk=0;
        int preostali = ukVojnika;
        for(i=0;i<this.strategija.size();i++){
            int tempVojnika = rn.nextInt(10000);
            //System.out.println("tempvoj: "+tempVojnika);
            this.strat[i]=tempVojnika;
            uk+=this.strat[i];
        }
        for(i=0;i<this.strategija.size()-1;i++){
            this.strategija.get(i).putVojnici((int)Math.floor((float)this.strat[i]/uk*ukVojnika));
            preostali-=(int)Math.floor((float)this.strat[i]/uk*ukVojnika);
        }
        preostali-=(int)Math.floor((float)this.strat[i]/uk*ukVojnika);
        this.strategija.get(i).putVojnici((int)Math.floor((float)this.strat[i]/uk*ukVojnika)+preostali);
    }
    void mutate(Player najbolji, int ukVojnika){
        int i;
        int uk=0;
        int preostali = ukVojnika;
        for(i=0;i<this.strategija.size();i++){
            int tempVojnika = rn.nextInt(1000)-500;
            this.strat[i] = ((int)Math.floor(najbolji.getBestStrat(i)*(1+(float)tempVojnika/10000)));
            uk+=this.strat[i];
        }
        for(i=0;i<this.strategija.size()-1;i++){
            this.strategija.get(i).putVojnici((int)Math.floor((float)this.strat[i]/uk*ukVojnika));
            preostali-=(int)Math.floor((float)this.strat[i]/uk*ukVojnika);
        }
        preostali-=(int)Math.floor((float)this.strat[i]/uk*ukVojnika);
        this.strategija.get(i).putVojnici((int)Math.floor((float)this.strat[i]/uk*ukVojnika)+preostali);
    }
    int getBestStrat(int i){
        return this.strat[i];
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
        String strateg="";
        for(int i=0;i<this.strategija.size();i++){
            strateg+=(this.strategija.get(i).getVojnici()+" ");
        }
        return strateg;
    }
}