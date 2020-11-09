package com.vchm;
import java.util.Random;

/**
 * F2: MF = MAX(MG)*(MH*MK)
 */

public class F2 extends Thread {
    int[][] MG, MH, MK;
    private int[][] result;
    private Formulas d;

    F2(String name, int priority, Formulas d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 2 start");
            int n = d.getN();
            int k = 3;
            int[][] MG = new int [n][n], MH = new int[n][n], MK = new int[n][n];

            /*for(int i = 0; i < n; i++){
                O[i] = 1;
                P[i] = 1;
                for (int j = 0; j < n; j++){
                    MR[i][j] = 1;
                    MT[i][j] = 1;
                }
            }*/
            int max = 10;
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    MG[i][j] = new Random().nextInt(max);
                    MH[i][j] = new Random().nextInt(max);
                    MK[i][j] = new Random().nextInt(max);
                }
            }
            result = d.func2(MG, MH, MK);
            //printMatr(MG, "MG");
            //printMatr(MH, "MH");
            //printMatr(MK, "MK");
            printMatr(result, "MF");
            sleep(250);
            System.out.println("Task 2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void printMatr(int[][] a, String name){
//        String res = "";
        System.out.println(name + ":");
        for(int i = 0; i < a.length; i++){
            System.out.print("[");
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("]");
        }
//        return res;
    }
}
