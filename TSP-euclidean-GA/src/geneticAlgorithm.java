
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
    public Rute Childsatu;
    public Rute Childdua;
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
//            if(randomNum < FlagMutasi){
//                mutation(arr[0],arr[1]);
//            }
            
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
        ArrayList<Kota> Childsatu = new ArrayList<>();
        ArrayList<Kota> Childdua = new ArrayList<>();
        
        double nilaiRandom = Math.random();
        double temp = nilaiRandom * parent1.getJumlahKota();
        int random = (int)temp;
        
        ArrayList<Kota> tempAnak1 = new ArrayList<>();
        for(int i=random; i<parent1.getJumlahKota(); i++){
            if(i!=0 && i!=parent1.getJumlahKota()){
                tempAnak1.add(parent1.getKota(i));
            }
        }
        for(int i=1; i<=parent2.getJumlahKota(); i++){
            for(int j=0; j<tempAnak1.size(); j++){
                if(parent2.getKota(i)!=tempAnak1.get(j)){
                    Childsatu.add(parent2.getKota(i));
                }
            }
        }
        Collections.shuffle(tempAnak1);
        for(int i=0; i<tempAnak1.size(); i++){
            Childsatu.add(tempAnak1.get(i));
        }
        
        RuteMethod rm = new RuteMethod(Childsatu,this.map); 
        rm.hitungJarakTotal();
        Rute satu = new Rute(Childsatu,rm.getJarak());
        return satu;
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
