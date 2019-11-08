/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class KumpulanRute {
    private Rute[] populasi;
    private int ukuranPopulasi;
    private double totalFitnessFunction;
    private double [][] range;
    
    public KumpulanRute(int ukuranPopulasi){
        this.ukuranPopulasi = ukuranPopulasi;
        this.populasi = new Rute[ukuranPopulasi];
        this.range = new double[this.populasi.length][this.populasi.length];
    }
    
    public void tambahRute(int index,Rute rute){
        this.populasi[index]=rute;
    }
    
    public int getPopulasiSize(){
        return this.ukuranPopulasi;
    }
    
    public Rute ambilRute(int index){
        return this.populasi[index];
    }
    
    public void hitungPeluang(){
        double total = 0;
        for(int i=0; i<this.populasi.length; i++){
            double peluang = this.populasi[i].getFitness()/this.totalFitnessFunction;
            this.populasi[i].setPeluang(peluang);
            total+=peluang;
            this.range[i][0]=peluang;
            this.range[i][1]=total;
        }   
    }
    
    public void printAllSolution(){
        for(int i=0; i<this.populasi.length; i++){
            if(this.populasi[i]!=null){
                System.out.print("Solution "+ i + ": ");
                for (int j = 1; j < populasi[i].getJumlahKota(); j++) {
                    System.out.print(this.populasi[i].getRute().get(j-1).getAngka()+" ");   
                }
                System.out.println("");
                System.out.print("Peluang :"+this.range[i][0]);
                System.out.println("");
                System.out.print("Cumulative :"+this.range[i][1]);
                System.out.println("");
                System.out.print("Fitness :"+this.populasi[i].getFitness());
                System.out.println("");
            }
        }
    }

    public void setTotalFitnessFunction(double totalFitnessFunction) {
        this.totalFitnessFunction = totalFitnessFunction;
    }

    public double[][] getRange() {
        return range;
    }
}
