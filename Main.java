package com.vchm;

public class Main extends Thread {

    public static void main(String[] args) {
        (new Main()).start();
    }

    @Override
    public void run() {
        setName("Lab 2");
        System.out.println("Lab 2 start\n");
        int n = 10;
        Formulas formulas = new Formulas(n);
        F1 f1 = new F1("F1", Thread.NORM_PRIORITY, formulas);
        F2 f2 = new F2("F2", Thread.MIN_PRIORITY, formulas);
        F3 f3 = new F3("F3", Thread.MAX_PRIORITY, formulas);

        f1.start();

        //стартуем второй поток только после 2-секундного ожидания первого потока (или когда он умрет/закончит выполнение)
        try {
            f1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f2.start();

        //стартуем 3-й поток только после того, как 1 поток закончит свое выполнение
        try {
            f1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f3.start();

        try { //задерживаем завершение f2 на три секунды после запуска f3
            f2.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //даем всем потокам возможность закончить выполнение перед тем, как программа (главный поток) закончит свое выполнение
        try {
            f1.join();
            f2.join();
            f3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nLab 2 end");
    }

}
