import java.util.List;
import java.util.ArrayList;

public class AiBlotto{
    
    public static void main(String[] args){

        int brGen = 20;             //broj generacija u evoluciji

        int brIgraca = 5000;          // broj igraca po generaciji



        /*
        
        uncomment ili postavi svoja pravila igre (bodove na kulama)
        
        */

        //int[] kule = {25,14,8,3,1,1,3,8,14,25}; 
        //int[] kule = {10,0,0,0,10};  
        //int[] kule = {10,10,10,10,10,10,10,10,10,10};
        int[] kule = {10,10,10,10,10,10};          
                                     // kule u igri

        int ukBrVojnika = 120;       // broj vojnika s kojim igrac raspolaze


/* 

Stvaramo generaciju od |brIgraca| igraca koji se medusobno bore

*/

        List<Player> generacija = new ArrayList<>();



        for (int i=0;i<brIgraca;i++){
            generacija.add(new Player());
            generacija.get(i).addKule(kule);
            generacija.get(i).calcRnStrategy(ukBrVojnika);
            //System.out.println(generacija.get(i).getStrategija());
        }


        for (int g=1; g<=brGen; g++){

/*

        U geneaciji prolazimo kroz sve igrace i gledamo koji igrac je imao najuspjesniju taktiku
        
*/
            

            for (int i=0;i<brIgraca-1;i++){
                for (int j=i+1;j<brIgraca;j++){
                    int pobj1=0,pobj2=0;
                    for (int k=0;k<kule.length;k++){
                        if (generacija.get(i).getVojniciFromKula(k)>generacija.get(j).getVojniciFromKula(k))
                            pobj1+=generacija.get(i).getBodoviFromKula(k);
                        else if (generacija.get(i).getVojniciFromKula(k)<generacija.get(j).getVojniciFromKula(k))
                            pobj2+=generacija.get(i).getBodoviFromKula(k);
                        else if (generacija.get(i).getVojniciFromKula(k)==generacija.get(j).getVojniciFromKula(k)){
                            pobj1+=generacija.get(i).getBodoviFromKula(k)/2;
                            pobj2+=generacija.get(i).getBodoviFromKula(k)/2;
                        }
                    }
                    if (pobj1>pobj2)
                        generacija.get(i).addScore(pobj1);
                    else if (pobj1<pobj2)
                        generacija.get(j).addScore(pobj2);
                    else{
                        generacija.get(i).addScore(pobj1);
                        generacija.get(j).addScore(pobj2);
                    }
                }
            }

/*

        memoriramo najbolju taktiku

*/

            Player najbolji = new Player();
            for (int i=0; i<brIgraca; i++){
                if (generacija.get(i).getScore()>najbolji.getScore()){
                    najbolji=generacija.get(i);
                }
            }
            System.out.println("Gen: "+g+"  Najbolji: "+najbolji.getStrategija());

/*

            resetiramo generaciju te kao prvog igraca sstavljamo najboljeg iz prethodne generacije

*/
            generacija.clear();
            najbolji.resetScore();
            generacija.add(najbolji);

/*

            popunjamo generaciju sa mutantima najboljeg igraca

*/

            for (int i=1;i<brIgraca;i++){
                generacija.add(new Player());
                generacija.get(i).addKule(kule);
                generacija.get(i).mutate(najbolji, ukBrVojnika);;
                //System.out.println(generacija.get(i).getStrategija());
            }
            najbolji=null;              //resetiramo najboljeg igraca


        }

    }
}