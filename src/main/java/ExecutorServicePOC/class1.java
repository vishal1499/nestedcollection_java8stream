package ExecutorServicePOC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class class1 {

    public static void main(String[] args) {
        int totalCores = Runtime.getRuntime().availableProcessors();
        System.out.println("totalCores: " + totalCores);
        ExecutorService service = Executors.newFixedThreadPool(totalCores);
        for (int i = 0; i < 100; i++) {
            executeTaks(service, i);
        }
        System.out.println("END");

        service.shutdown();
    }

    private static void executeTaks(ExecutorService service, int i) {
        service.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " : " + Thread.currentThread().getName());
        });
    }
}
