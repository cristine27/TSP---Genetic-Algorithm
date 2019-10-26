
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class KumpulanKota {
    private ArrayList<Kota> kumpulanK;
    private double [][] jarak;
    private int jumlahKota;
    private int fitnes;
    private int cost;
    
    public KumpulanKota(){
        kumpulanK = new ArrayList<>();
        this.cost = 0;
        this.fitnes = 0;
    }
    
    public void addKota(Kota kotaBaru){
        this.kumpulanK.add(kotaBaru);
    }
    
    public void banyakKota(){
        this.jumlahKota = this.kumpulanK.size();
        this.jarak = new double[this.jumlahKota+1][this.jumlahKota+1]; 
    }
    
    public Kota getKota(int i){
        return this.kumpulanK.get(i);
    }
    
    public void hitungJarakTiapKota(){
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
    
    public int getFitnes(){
        this.fitnes = 1/this.cost;
        return this.fitnes;
    }
}
