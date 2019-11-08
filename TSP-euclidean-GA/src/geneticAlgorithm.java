
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
    public static final boolean elitism = true;
    
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
    
    public void saveRute(){
        if(elitism){
            //untuk menyimpan rute terbaik yang telah di temukan saat ini
        }
    }
    
    public KumpulanRute makeNewGeneration(KumpulanRute rute){
        int jumlahGenerasi = 10;
        KumpulanRute newKRute = new KumpulanRute(rute.getPopulasiSize());
        int generasiKe = 1;
        for(int i=0; i<jumlahGenerasi; i++){
            Rute parent1 = selection(rute);
            Rute parent2 = selection(rute);
            
            Rute [] arr = crossOver(parent1,parent2);
            newKRute.tambahRute(generasiKe++, arr[0]);
            newKRute.tambahRute(generasiKe++, arr[1]);
        }
        return newKRute;
    }
    
    public Rute[] crossOver(Rute parent1, Rute parent2){
        ArrayList<Kota> Childsatu = new ArrayList<>();
        ArrayList<Kota> Childdua = new ArrayList<>();
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
                    Childdua.add(parent1.getKota(i));
                }
            }
        }
        Collections.shuffle(tempAnak1);
        for(int i=0; i<tempAnak2.size(); i++){
            Childdua.add(tempAnak2.get(i));
        }
        
        RuteMethod rm = new RuteMethod(Childsatu,this.map); 
        rm.hitungJarakTotal();
        Rute satu = new Rute(Childsatu,rm.getJarak());
        rm = new RuteMethod(Childdua, this.map);
        rm.hitungJarakTotal();
        Rute dua = new Rute(Childdua,rm.getJarak());
        Rute [] arr = new Rute[2];
        arr[0] = satu;
        arr[1] = dua;
        return arr;
    }
    
    public void mutation(){
//        double nilaiRandom = Math.random();
//        double temp1 = nilaiRandom * this.Childsatu.size();
//        double temp2 = nilaiRandom * this.Childdua.size();
//        int indexRandom1 = (int)temp1;
//        int indexRandom2 = (int)temp2;
//        
//        Kota kota1 = this.Childsatu.get(indexRandom1);
//        Kota kota2 = this.Childsatu.get(indexRandom2);
//        this.Childsatu.set(indexRandom1, kota2);
//        this.Childsatu.set(indexRandom2, kota1);
//        
//        Kota kota3 = this.Childdua.get(indexRandom1);
//        Kota kota4 = this.Childdua.get(indexRandom2);
//        this.Childdua.set(indexRandom1, kota4);
//        this.Childdua.set(indexRandom2, kota3);
    }
    
    
}
