
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int populationSize = 101;
        ArrayList<Kota> kumpulanKota = new ArrayList<>();
        while(sc.hasNextInt()){
            Kota kota = new Kota(sc.nextInt(),sc.nextInt(),sc.nextInt()); 
            kumpulanKota.add(kota);
        }
        int jumlahKota = kumpulanKota.size();
        double[][] jarakTiapKota = new double[jumlahKota+1][jumlahKota+1];
        for(int i=0; i<jarakTiapKota.length-1; i++){
            for(int j=0; j<jarakTiapKota.length-1; j++){
                if(i==j){
                    jarakTiapKota[kumpulanKota.get(i).getAngka()][kumpulanKota.get(j).getAngka()]=0;
                }
                else{
                    int X = kumpulanKota.get(i).getX()-kumpulanKota.get(j).getX();
                    int Y = kumpulanKota.get(i).getY()-kumpulanKota.get(j).getY();
                    double dist = Math.sqrt((X*X)+(Y*Y));
                    jarakTiapKota[kumpulanKota.get(i-1).getAngka()][kumpulanKota.get(j).getAngka()]=dist;
                    jarakTiapKota[kumpulanKota.get(i-1).getAngka()][kumpulanKota.get(j).getAngka()]=dist;
                }
            }
        }
        
        KumpulanRute populasi = new KumpulanRute(populationSize);
        double totalFitness = 0;
        for(int i=0; i<populationSize; i++){
            Rute rute = new Rute(kumpulanKota);
            rute.hitungJarakTotal(jarakTiapKota);
            populasi.tambahRute(i, rute);
            totalFitness+=rute.getFitness();
        }
        populasi.setTotalFitnessFunction(totalFitness);
        populasi.hitungPeluang();
        populasi.printAllSolution();
    }
}
