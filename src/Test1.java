import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        int a = 100;
        MyThread myThread = new MyThread(countDownLatch, a);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Thread(myThread));
            countDownLatch.countDown();
        }
    }
}
