
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
        int populationSize = 10;
        ArrayList<Kota> kumpulanKota = new ArrayList<>();
        while(sc.hasNextInt()){
            int angka = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            Kota kota = new Kota(angka,x,y); 
            kumpulanKota.add(kota);
        }
        int jumlahKota = kumpulanKota.size();
        double[][] jarakTiapKota = new double[jumlahKota+1][jumlahKota+1];
        for(int i=0; i<jarakTiapKota.length-1; i++){
            for(int j=0; j<jarakTiapKota.length-1; j++){
                if(kumpulanKota.get(i).getAngka()==kumpulanKota.get(j).getAngka()){
                    jarakTiapKota[kumpulanKota.get(i).getAngka()][kumpulanKota.get(j).getAngka()]=0;
                }
                else{
                    int X = kumpulanKota.get(i).getX()-kumpulanKota.get(j).getX();
                    int Y = kumpulanKota.get(i).getY()-kumpulanKota.get(j).getY();
                    double dist = Math.sqrt((X*X)+(Y*Y));
                    jarakTiapKota[kumpulanKota.get(i).getAngka()][kumpulanKota.get(j).getAngka()]=dist;
                    jarakTiapKota[kumpulanKota.get(j).getAngka()][kumpulanKota.get(i).getAngka()]=dist;
                }
            }
        }
        
        KumpulanRute populasi = new KumpulanRute(populationSize);
        double totalFitness = 0;
        for(int i=0; i<populationSize; i++){
            RuteMethod tempRute = new RuteMethod(kumpulanKota, jarakTiapKota);
            tempRute.acakRute();
            double jarak = tempRute.getJarak();
            ArrayList<Kota> tempList = (ArrayList<Kota>)tempRute.getKumpulanKota().clone();
            Rute rute = new Rute(tempList,jarak);
            populasi.tambahRute(i, rute);
            totalFitness+=rute.getFitness();
        }
        populasi.setTotalFitnessFunction(totalFitness);
        populasi.hitungPeluang();
        
        geneticAlgorithm ga = new geneticAlgorithm(jarakTiapKota);
        KumpulanRute newPopulasi = new KumpulanRute(populationSize);
        Rute solutionRute = ga.makeNewGeneration(populasi);
        
        ArrayList<Kota> kotaSolution = solutionRute.getRute();
        System.out.println(solutionRute.getJumlahKota());
       
        System.out.println("Maka Rute paling optimal : ");
        for(int i=1; i<solutionRute.getJumlahKota(); i++){
            System.out.println(solutionRute.getKota(i).getAngka());
        }
        System.out.println("Fitness value : ");
        System.out.printf("%.5f",solutionRute.getFitness());
        System.out.println("");
        System.out.println("Merupakan generasi ke : ");
        System.out.println(ga.getGenerasi());
    }
}
