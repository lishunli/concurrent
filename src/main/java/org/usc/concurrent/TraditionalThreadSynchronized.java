package org.usc.concurrent;

/**
 * 同步
 *
 * @author ShunLi
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args) {
        final Outputer outputer = new Outputer();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // outputer.output1("i love java");
                    outputer.output2("i love java");
                    // outputer.output3("i love java");
                    // outputer.output4("i love java");
                }

            }
        }).start();

        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // outputer.output1("lishunli");
                    // outputer.output2("lishunli");
                    // outputer.output3("lishunli");
                    outputer.output4("lishunli");
                }

            }
        }).start();

    }

    // synchronized 如果要达到同步的功能，必须锁定同一个对象
    static class Outputer {

        public void output1(String name) {
            int len = name.length();

            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public void output2(String name) {
            int len = name.length();

            synchronized (Outputer.class) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output3(String name) {
            int len = name.length();

            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output4(String name) {
            int len = name.length();

            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}
