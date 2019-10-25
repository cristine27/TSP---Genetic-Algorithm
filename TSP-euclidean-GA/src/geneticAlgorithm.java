
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
    
    public geneticAlgorithm(int jlKota){
        this.Childsatu = new int[jlKota];
        this.Childdua = new int[jlKota];
    }
    
    public void crossOver(int [] parent1, int [] parent2){
        double nilaiRandom = Math.random();
        int random =(int)nilaiRandom * parent1.length-1;
        for(int i=0; i<parent1.length; i++){
            if(i<random){
                this.Childsatu[i] = parent1[i];
                this.Childdua[this.Childdua.length-1-i] = parent1[this.Childsatu.length-1-i]; 
            }
            else{
                this.Childdua[i] = parent2[i];
                this.Childdua[this.Childdua.length-1-i] = parent2[this.Childdua.length-1-i];
            }
        }
        
        
    }
}
