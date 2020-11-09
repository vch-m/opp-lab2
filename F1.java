package com.vchm;
import java.util.Random;

/**
 * F1: C = A + B*(MO*ME)
 */

public class F1 extends Thread {

    int[] A, B;
    int[][] MO, ME;
    private int[] result;
    private Formulas d;




    F1(String name, int priority, Formulas d) {
        setName(name);
        setPriority(priority);
        this.d = d;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task 1 start");
//            int n = 3;
            int n = d.getN();
            int[] A = new int[n], B = new int[n], C = new int[n];
            int[][] MO = new int [n][n], ME = new int[n][n];
//            for(int i = 0; i < n; i++){
//                A[i] = 1;
//                B[i] = 1;
//                C[i] = 1;
//                for (int j = 0; j < n; j++){
//                    MO[i][j] = 1;
//                    ME[i][j] = 1;
//                }
//            }
            int max = 10;
            for(int i = 0; i < n; i++){
                A[i] = new Random().nextInt(max);
                B[i] = new Random().nextInt(max);
                C[i] = new Random().nextInt(max);
                for (int j = 0; j < n; j++){
                    MO[i][j] = new Random().nextInt(max);
                    ME[i][j] = new Random().nextInt(max);
                }
            }


            result = d.func1(A, B, MO, ME);
            sleep(500);
//            printVect(A, "A");
//            printVect(B, "B");;
//            printMatr(MO, "MO");
//            printMatr(MO, "ME");
            printVect(result, "C");

            System.out.println("Task 1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printVect(int[] a, String name){
//        String res = "";
        System.out.print(name + ": [");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
//        return res;
    }
}