package iegcode.virtual.thread;

import java.io.IOException;

public class VirtualTheardTest {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.ofVirtual().name("Gibran-" + i).unstarted(() -> {
                try {
                Thread.sleep(java.time.Duration.ofSeconds(1));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
        System.in.read();
    }
}
