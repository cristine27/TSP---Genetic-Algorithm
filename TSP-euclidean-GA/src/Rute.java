
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Rute {
    private ArrayList<Kota> KumpulanKota;
    private double fitness;
    private int jumlahKota;
    private double jarakTotal;
    private double peluang;
//    private double kumulatifPeluang;
    
    public Rute(ArrayList<Kota> KK,double jarak){
        this.KumpulanKota = KK;
        this.jumlahKota = KK.size();
        this.jarakTotal = jarak;
    }
    
    public int getJumlahKota(){
        return this.jumlahKota;
    }
    
    public Kota getKota(int i){
        return this.KumpulanKota.get(i-1);
    }
    
    public ArrayList<Kota> getRute(){
        return this.KumpulanKota;
    }
    
    public double getFitness(){
        this.fitness = 1/this.jarakTotal;
        return this.fitness;
    }
    
    public double getPeluang() {
        return peluang;
    }
    
    public void setPeluang(double peluang) {
        this.peluang = peluang;
    }
    
    public void setKota(int index,Kota newKota){
        if(index>0){
            this.KumpulanKota.set(index+1, newKota);
        }
    }
}
