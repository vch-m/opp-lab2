package com.vchm;
import java.util.Arrays;
import java.util.Scanner;
/**
 F1 -  C = A + B*(MO*ME)
 F2 -  MF = MAX(MG)*(MH*MK)
 F3 -  S = (O + P)*SORT(MT*MR)
 *
 */
public class Formulas {
    private int n;

    public int getN() {
        return n;
    }

    public Formulas(int n) {
        this.n = n;
    }

    public int[] vectorInput() {
        int[] vector = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            vector[i] = sc.nextInt();
        }
        return vector;
    }

    public int[][] matrixInput() {
        int[][] matrix = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ;
                 j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    //F1 -  C = A + B*(MO*ME)
    public int[] func1(int[] a, int[] b, int[][] mo, int[][] me) {
        return vectorAdd(a, vectorMatrixMult(b, matrixMult(mo, me)));
    }

    //F2 -  MF = MAX(MG)*(MH*MK)
    public int[][] func2(int[][] mg, int[][] mh, int[][] mk) {
        return intMatrixMult(matrixMax(mg), matrixMult(mh, mk));
    }

    //F3 -  S = (O + P)*SORT(MT*MR)
    public int[] func3(int[] o, int[] p, int[][] mr, int[][] mt) {
        return vectorMatrixMult(vectorAdd(o, p), matrixSort(matrixMult(mt, mr)));
    }

    private int[] vectorAdd(int[] a, int[] b) {
        if (a.length != n || b.length != n) {
            System.out.println("null");
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            c[i] = a[i] + b[i];
        }
        return c;
    }

    private int matrixMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    private int[][] intMatrixMult(int a, int[][] b) {
        int[][] c = new int[n][n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++) {
                c[i][j] = a * b[i][j];
            }
        }
        return c;
    }


    private int[] vectorMatrixMult(int[] a, int[][] ma) {
        if (a.length != n || ma.length != n) {
            return null;
        }
        int[] c = new int[n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                c[i] += a[j] * ma[j][i];
            }
        }
        return c;
    }

    private int[][] matrixMult(int[][] ma, int[][] mb) {
        if (ma.length != n || mb.length != n) {
            return null;
        }
        int[][] c = new int[n][n];
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                for (int k = 0; k < n ; k++){
                    c[i][j] += ma[i][k] * mb[k][j];
                }
            }
        }
        return c;
    }

    private int[] vectorSort(int[] a) {
        if (a.length != n) {
            return null;
        }
        int[] c = Arrays.copyOf(a, n);
        Arrays.sort(c);
        int[] res = new int[c.length];
        for (int i = c.length; i > 0; i--){
            res[i-1] = c[c.length - i];
        }
        return res;
    }

    private int[][] matrixSort(int[][] a){
        if (a.length != n) {
            return null;
        }
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < c.length; i++){
            c[i] = vectorSort(a[i]);
        }

        return c;

    }
}