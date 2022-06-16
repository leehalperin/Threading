package com.sparta.lh;


public class ThreadBasics {
    private static class Greeter extends Thread {
        private String name;

        public Greeter (String name) {
        this.name =name;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    @Override
    public void run() {
        sayHello();
    }

}



    public static void main( String[] args )
    {
       Greeter greeter1 = new Greeter ("Manish");
       Greeter greeter2 = new Greeter("Danny");
        Thread thread1 = new Thread (greeter1);
        Thread thread2 = new Thread (greeter2);

        System.out.println("Starting....");
        greeter1.sayHello();
        greeter2.sayHello();
        System.out.println("Finished!");
    }
}
