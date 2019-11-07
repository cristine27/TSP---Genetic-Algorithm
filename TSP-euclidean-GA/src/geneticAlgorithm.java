
import java.util.ArrayList;
import java.util.Collections;
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
    public ArrayList<Kota> Childsatu;
    public ArrayList<Kota> Childdua;
    public Rute savedRute;
    public static final boolean elitism = true;
    
    public geneticAlgorithm(){
    }
    
    public void saveRute(){
        if(elitism){
            //untuk menyimpan rute terbaik yang telah di temukan saat ini
        }
    }
    
    public void crossOver(Rute parent1, Rute parent2){
        double nilaiRandom = Math.random();
        double temp = nilaiRandom * parent1.getJumlahKota();
        int random = (int)temp;
        ArrayList<Kota> tempAnak1 = new ArrayList<>();
        for(int i=random; i<parent1.getJumlahKota(); i++){
            tempAnak1.add(parent1.getKota(i));
        }
        for(int i=0; i<parent2.getJumlahKota(); i++){
            for(int j=0; j<tempAnak1.size()-1; j++){
                if(parent2.getKota(i)!=tempAnak1.get(j)){
                    Childsatu.add(parent2.getKota(i));
                }
            }
        }
        Collections.shuffle(tempAnak1);
        for(int i=0; i<tempAnak1.size(); i++){
            Childsatu.add(tempAnak1.get(i));
        }
        
        nilaiRandom = Math.random();
        temp = nilaiRandom * parent2.getJumlahKota();
        random = (int) temp;
        ArrayList<Kota> tempAnak2 = new ArrayList<>();
        for(int i=random; i<parent2.getJumlahKota(); i++){
            tempAnak2.add(parent2.getKota(i));
        }
        for(int i=0; i<parent1.getJumlahKota(); i++){
            for(int j=0; j<tempAnak2.size()-1; j++){
                if(parent1.getKota(i)!=tempAnak2.get(j)){
                    Childsatu.add(parent1.getKota(i));
                }
            }
        }
        Collections.shuffle(tempAnak1);
        for(int i=0; i<tempAnak2.size(); i++){
            Childsatu.add(tempAnak2.get(i));
        }
    }
    
    public void mutation(){
        double nilaiRandom = Math.random();
        double temp1 = nilaiRandom * this.Childsatu.size();
        double temp2 = nilaiRandom * this.Childdua.size();
        int indexRandom1 = (int)temp1;
        int indexRandom2 = (int)temp2;
        
        Kota kota1 = this.Childsatu.get(indexRandom1);
        Kota kota2 = this.Childsatu.get(indexRandom2);
        this.Childsatu.set(indexRandom1, kota2);
        this.Childsatu.set(indexRandom2, kota1);
        
        Kota kota3 = this.Childdua.get(indexRandom1);
        Kota kota4 = this.Childdua.get(indexRandom2);
        this.Childdua.set(indexRandom1, kota4);
        this.Childdua.set(indexRandom2, kota3);
    }
    
    
}
