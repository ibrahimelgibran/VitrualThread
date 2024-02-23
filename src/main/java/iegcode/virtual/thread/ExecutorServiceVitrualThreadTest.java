package iegcode.virtual.thread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceVitrualThreadTest {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(java.time.Duration.ofSeconds(1));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.in.read();
    }
}
