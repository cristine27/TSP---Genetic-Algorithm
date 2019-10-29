
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
    private ArrayList<Kota> Rute;
    private double [][] jarak;
    private int jumlahKota;
    private double fitnes;
    private boolean isFitnessChange;
    private double cost;
    
    public Rute(ArrayList<Kota> list){
        this.Rute = new ArrayList<>();
        this.Rute.addAll(list);
        Collections.shuffle(this.Rute);
        this.fitnes = 0;
        this.isFitnessChange = true;
    }

    public ArrayList<Kota> getRute() {
        if(isFitnessChange){
            this.fitnes = this.getFitnes();
            isFitnessChange=false;
        }
        return Rute;
    }

    public int getJumlahKota() {
        return jumlahKota;
    }
    
    public void addKota(Kota kotaBaru){
        this.Rute.add(kotaBaru);
    }
    
    public void hitungJarakTiapKota(){
        this.jumlahKota = this.Rute.size();
        for(int i=0; i<this.jumlahKota; i++){
            for(int j=0; j<this.jumlahKota; j++){
                if(i==j){
                    continue;
                }
                else{
                    double x = this.getKota(i).getX()-this.getKota(j).getX();
                    double y = this.getKota(i).getY()-this.getKota(j).getY();
                    this.jarak[i][j] = Math.sqrt((x*x)+(y*y));
                    this.jarak[j][i] = Math.sqrt((x*x)+(y*y));
                    this.cost += this.jarak[i][j]; 
                }
            }
        }
    }
    
    public double getFitnes(){
        this.fitnes = 1/this.cost;
        return this.fitnes;
    }
    
    public Kota getKota(int i){
        return this.Rute.get(i);
    }
}
