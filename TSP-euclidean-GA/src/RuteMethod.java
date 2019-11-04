
import java.util.ArrayList;
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
public class RuteMethod {
    private int jarak;
    private double [][] jarakTiapKota;
    private ArrayList<Kota> kumpulanKota;
    private int totalKota;
    
    public RuteMethod(ArrayList<Kota> list, double [][] map){
        this.jarak = 0;
        this.jarakTiapKota = map;
        this.kumpulanKota = list;
        this.totalKota = list.size();
    }
    
    public void hitungJarakTotal(){
        for(int i=0; i<this.totalKota; i++){
            this.jarak+=jarakTiapKota[kumpulanKota.get(i).getAngka()][kumpulanKota.get(i+1).angka];
        }
    }
    
    public ArrayList<Kota> acakRute(){
        Collections.shuffle(kumpulanKota);
        this.hitungJarakTotal();
        return this.kumpulanKota;
    }

    public ArrayList<Kota> getKumpulanKota() {
        return kumpulanKota;
    }

    public int getJarak() {
        return jarak;
    }
}
