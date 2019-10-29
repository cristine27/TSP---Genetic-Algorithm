/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Kota {
    int x;
    int y;
    int angka;
    
    public Kota(int angka,int x,int y){
        this.x = x;
        this.y = y;
        this.angka = angka;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAngka() {
        return angka;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAngka(int angka) {
        this.angka = angka;
    }
    
    public double distanceToOther(Kota kotaLain){
        int xDistance = Math.abs(this.getX() - kotaLain.getX());
        int yDistance = Math.abs(this.getY() - kotaLain.getY());
        
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance));
        return distance;
    }
}
