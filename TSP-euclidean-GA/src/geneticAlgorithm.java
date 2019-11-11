
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
    public Rute savedRute;
    public double [][] map;
    public int fitnessFlag = 0;
    public int generasi = 0;
    
    public geneticAlgorithm(double [][] map){
        this.map = map;
    }
    
    public Rute selection(KumpulanRute rute){
        double [][] range = rute.getRange();
        double angkaRandom = Math.random();
        int titikAmbil = 0;
        for(int i=0; i<range.length; i++){
            if(range[i][0]<=angkaRandom && angkaRandom<=range[i][1]){
                titikAmbil = i;
                break;
            }
        }
        return rute.ambilRute(titikAmbil);
    }
    
    public Rute makeNewGeneration(KumpulanRute rute){
        int jumlahGenerasi = 50;
        KumpulanRute newKRute = new KumpulanRute(jumlahGenerasi);
        int generasiKe = 1;
        for(int i=0; i<jumlahGenerasi; i++){
            Rute parent1 = selection(rute);
            Rute parent2 = selection(rute);
            Rute [] arr = new Rute[2];
            arr[0] = crossOver(parent1, parent2);
            arr[1] = crossOver(parent2, parent1);
            double FlagMutasi = 0.5;
            double randomNum = Math.random();
            if(randomNum < FlagMutasi){
                mutation(arr[0],arr[1]);
            }
            
            newKRute.tambahRute(generasiKe++, arr[0]);
            newKRute.tambahRute(generasiKe++, arr[1]);
            
//          diasumsikan child pertama mempunyai fitnes yang paling bagus.
            savedRute = arr[0];
            if(savedRute.getFitness()<arr[0].getFitness()){
                savedRute = arr[0];
                this.generasi = generasiKe;
            }
            if(savedRute.getFitness()<arr[1].getFitness()){
                savedRute = arr[1];
                this.generasi = generasiKe;
            }
            
            if(savedRute.getFitness()==arr[0].getFitness() || savedRute.getFitness()==arr[0].getFitness()){
                fitnessFlag++;
                this.generasi = generasiKe;
            }
            if(fitnessFlag>5){
                break;
            }
        }
        return savedRute;
    }
    
    public Rute crossOver(Rute parent1, Rute parent2){
        Rute copyParent1 = parent1;
        Rute copyParent2 = parent2;
        
        Random rand = new Random();
        int breakPoint = rand.nextInt(parent1.getJumlahKota());
        for(int i=1; i<=breakPoint; i++){
            Kota angka = copyParent2.getKota(i);
            for(int j=1; j<=copyParent1.getJumlahKota(); j++){
                if(copyParent1.getKota(j)==angka){
                    Kota temp = copyParent1.getKota(i);
                    copyParent1.setKota(i, copyParent1.getKota(j));
                    copyParent1.setKota(j, temp);
                }
            }
        }
        return copyParent1;
    }
    
    public void mutation(Rute satu , Rute dua){
        double nilaiRandom = Math.random();
        double temp1 = nilaiRandom * satu.getJumlahKota();
        double temp2 = nilaiRandom * dua.getJumlahKota();
        int indexRandom1 = (int)temp1;
        int indexRandom2 = (int)temp2;
        
        if(indexRandom1<=0){
            nilaiRandom = Math.random();
            temp1 = nilaiRandom * satu.getJumlahKota();
            indexRandom1 =  (int)temp1;
        }
        if(indexRandom2<=0){
            nilaiRandom = Math.random();
            temp2 = nilaiRandom * dua.getJumlahKota();
            indexRandom2 =  (int)temp2;
        }
        
        Kota satuIndex1 = satu.getKota(indexRandom1);
        Kota satuIndex2 = satu.getKota(indexRandom2);
        Kota duaIndex1 = dua.getKota(indexRandom1);
        Kota duaIndex2 = dua.getKota(indexRandom2);
        satu.setKota(indexRandom1, satuIndex2);
        satu.setKota(indexRandom2, satuIndex1);
        dua.setKota(indexRandom1, duaIndex2);
        dua.setKota(indexRandom2, duaIndex1);
    }
    
    public int getGenerasi(){
        return this.generasi;
    }
}
