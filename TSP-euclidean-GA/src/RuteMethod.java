
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
    private double jarak;
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
        for(int i=1; i<this.totalKota; i++){
            int x = this.get(i).getAngka();
            int y = this.get(i+1).getAngka();
            this.jarak+=jarakTiapKota[x][y];
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

    public double getJarak() {
        return jarak;
    }
    
    public Kota get(int i){
        return this.kumpulanKota.get(i-1);
    }
}
