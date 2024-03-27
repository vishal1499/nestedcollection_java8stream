package CompletableFuturePOC;

import java.util.concurrent.CompletableFuture;

public class CF_POC {

    public static void main(String[] args) throws InterruptedException {
        //CompletableFuture<String> completableFuture = new CompletableFuture<>();
        //completableFuture.
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        Task t0 = new Task("TestVal");
        t0.start();

        Task1 t1 = new Task1("Runnable Test");

        Thread th1 = new Thread(t1);
        th1.start();

        new Thread(() -> {
            System.out.println("running inside Lambda1....");
            System.out.println("Thread Name: " +Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            System.out.println("running inside Lambda2....");
            System.out.println("Thread Name: " +Thread.currentThread().getName());
        }).start();

    }
}

class Task extends Thread{

    String param;

    public Task() {

    }

    public Task(String param) {
        this.param = param;
    }

    @Override
    public void run() {
        System.out.println("running my code with new thread....");
        System.out.println("Thread Name: " + param + " : "+Thread.currentThread().getName());
        super.run();
    }
}

class Task1 implements Runnable{

    String param;

    public Task1() {

    }

    public Task1(String param) {
        this.param = param;
    }

/*
    @Override
    public void run() {

    }
*/

    @Override
    public void run() {
        System.out.println("running my code with new thread....");
        System.out.println("Thread Name: " + param + " : "+Thread.currentThread().getName());

    }
}