package iegcode.virtual.thread;

public class Duration {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.ofPlatform().daemon(false).unstarted(() -> {
                try {
                Thread.sleep(java.time.Duration.ofSeconds(1));
                    System.out.println("Hello " + Thread.currentThread() + "1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }
}
