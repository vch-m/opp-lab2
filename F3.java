package com.vchm;

import java.util.Random;

/**
 * F3: S = (O + P)*SORT(MT*MR)
 */

public class F3 extends Thread {
    int[] O, P;
    int[][] MR, MT;
    private int[] result;
    private Formulas d;

    F3(String name, int priority, Formulas d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 3 start");
            int n = d.getN();
            int[] O = new int[n], P = new int[n];
            int[][] MR = new int [n][n], MT = new int[n][n];

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
                O[i] = new Random().nextInt(max);
                P[i] = new Random().nextInt(max);
                for (int j = 0; j < n; j++){
                    MR[i][j] = new Random().nextInt(max);
                    MT[i][j] = new Random().nextInt(max);
                }
            }
            result = d.func3(O, P, MR, MT);
            sleep(100);
            System.out.println("Task 3 end");
//            printVect(O, "O");
//            printVect(P, "P");
//            printMatr(MR, "MR");
//            printMatr(MT, "MT");
            printVect(result, "S");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printVect(int[] a, String name){
//        String res = "";
        for(int i = 0; i < a.length; i++){
        System.out.print(name + ": [");
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
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
    }
}
