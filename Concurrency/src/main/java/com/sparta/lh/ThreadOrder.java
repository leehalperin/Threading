package com.sparta.lh;

import java.util.ArrayList;

public class ThreadOrder {
    private static ArrayList<Integer> numbers = new ArrayList<>();
    private static class Loop implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i<20;i++){
            //System.out.println(Thread.currentThread().getName() + ": " + i);
                numbers.add(i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Loop());
        Thread thread2 = new Thread(new Loop());
        thread1.setName("Loop Thread 1");
        thread2.setName("Loop Thread 2");

        try {
            thread1.start();
            thread1.join();
            thread2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
}
