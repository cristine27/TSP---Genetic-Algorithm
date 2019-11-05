
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class geneticAlgorithm {
    public int [] Childsatu;
    public int [] Childdua;
    public Rute savedRute;
    public static final boolean elitism = true;
    
    public geneticAlgorithm(int jlKota){
        this.Childsatu = new int[jlKota];
        this.Childdua = new int[jlKota];
    }
    
    public void saveRute(){
        if(elitism){
            //untuk menyimpan rute terbaik yang telah di temukan saat ini
        }
    }
    
    public void crossOver(Rute parent1, Rute parent2){
        double nilaiRandom = Math.random();
        int random =(int)nilaiRandom * parent1.getJumlahKota();
        System.out.println("ini nilai random "+random);
        for(int i=random; i<parent1.getJumlahKota(); i++){
            
        }
    }
    
    public void mutation(){
        double nilaiRandom = Math.random();
        int indexRandom1 = (int)nilaiRandom * this.Childsatu.length-1;
        int indexRandom2 = (int)nilaiRandom * this.Childdua.length-1;
        
        int temp = this.Childsatu[indexRandom1];
        this.Childsatu[indexRandom1] = this.Childsatu[indexRandom2];
        this.Childsatu[indexRandom2] = temp;
        
        int temp2 = this.Childdua[indexRandom1];
        this.Childdua[indexRandom1] = this.Childdua[indexRandom2];
        this.Childdua[indexRandom2] = temp;
    }
}
