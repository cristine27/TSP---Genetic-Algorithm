
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
    private double kumulatifPeluang;
    
    public Rute(ArrayList<Kota> KK){
        this.KumpulanKota = KK;
        this.jumlahKota = KK.size();
    }
    
    public int getJumlahKota(){
        return this.jumlahKota;
    }
    
    public Kota getKota(int i){
        return this.KumpulanKota.get(i-1);
    }
    
    public double getFitness(){
        this.fitness = 1/this.jarakTotal;
        return this.fitness;
    }
    
    public ArrayList<Kota> getRute(){
        return this.KumpulanKota;
    }
    
    public void hitungJarakTotal(double[][] jarakTiapKota){
        this.jarakTotal = 0;
        for(int i=1; i<this.jumlahKota; i++){
            this.jarakTotal+=jarakTiapKota[this.getKota(i).getAngka()][this.getKota(i+1).angka];
        }
    }
    
    public ArrayList<Kota> acakRute(double[][]jarakTiapKota){
        Collections.shuffle(KumpulanKota);
        this.hitungJarakTotal(jarakTiapKota);
        return this.KumpulanKota;
    }

    public double getPeluang() {
        return peluang;
    }

    public double getKumulatifPeluang() {
        return kumulatifPeluang;
    }

    public void setPeluang(double peluang) {
        this.peluang = peluang;
    }

    public void setKumulatifPeluang(double kumulatifPeluang) {
        this.kumulatifPeluang = kumulatifPeluang;
    }
}
