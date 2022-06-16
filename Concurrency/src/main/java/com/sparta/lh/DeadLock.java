package com.sparta.lh;

public class DeadLock {

    private static class Friend {
        private String name;

        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public synchronized void bow(Friend bower) {
            System.out.println(name + ": " + bower.getName() + " has bowed to me!" + "\n");
            bower.bowBack(this);
        }
        private synchronized void bowBack(Friend bower) {
            System.out.println(name + ": " bower.getName() + "had bowed to me!" + "\n");
        }
    }

    public static void main(String[] args) {
        Friend manish = new Friend("Manish");
        Friend josh = new Friend("Josh");

        new Thread()) -> manish.bow(josh)).start();
        new Thread()) -> josh.bow(manish)).start();
    }
}
