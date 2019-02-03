import java.util.List;
import java.util.ArrayList;

public class AiBlotto{




    public static void main(String[] args){

        int brGen = 10;             //broj generacija u evoluciji

        int brIgraca = 40;          // broj igraca po generaciji
        int brKula = 10;             // broj kula u igri
        int ukBrVojnika = 100;       // broj vojnika s kojim igrac raspolaze


/* 

Stvaramo generaciju od 100 igraca koji se medusobno bore

*/

        List<Player> generacija = new ArrayList<>();


        //for (int g=1; g<=brGen; g++){


            for (int i=0;i<brIgraca;i++){
                generacija.add(new Player());
                generacija.get(i).addKule(brKula);
                generacija.get(i).calcRnStrategy(ukBrVojnika);
                //System.out.println(generacija.get(i).getStrategija());
            }

            for (int i=0;i<brIgraca;i++){
                for (int j=i+1;j<brIgraca;j++){
                    int pobj1=0,pobj2=0;
                    for (int k=0;k<brKula;k++){
                        if (generacija.get(i).getVojniciFromKula(k)>generacija.get(j).getVojniciFromKula(k))
                            pobj1+=2;
                        else if (generacija.get(i).getVojniciFromKula(k)<generacija.get(j).getVojniciFromKula(k))
                            pobj2+=2;
                        else{
                            pobj1++;
                            pobj2++;
                        }
                    }
                    if (pobj1>pobj2)
                        generacija.get(i).addScore(2);
                    else if (pobj1<pobj2)
                        generacija.get(j).addScore(2);
                    else{
                        generacija.get(i).addScore(1);
                        generacija.get(j).addScore(1);
                    }
                }
            }
            Player najbolji = new Player();
            for (int i=0; i<brIgraca; i++){
                if (generacija.get(i).getScore()>najbolji.getScore()){
                    najbolji=generacija.get(i);
                }
            }
            System.out.println("Najbolji: "+najbolji.getStrategija());



        }

   // }
}