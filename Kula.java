class Kula{
// varijable objekta kula
    private int bodovi;
    private int vojnici;

//-----------------------------------------------
// inicijalizacija kule
    Kula(int bodovi_){
        this.bodovi=bodovi_;
    }
//---------------------------------------------
    void putVojnici(int brVojnika){
        this.vojnici=brVojnika;
    }
    int getVojnici(){
        return this.vojnici;
    }
    int getBodovi(){
        return this.bodovi;
    }
}