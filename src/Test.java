import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static volatile int a = 0;

    public static void concurrenceTest() {
        /**
         * 模拟高并发情况代码
         */
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        final CountDownLatch countDownLatch = new CountDownLatch(100); // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ThreadPoolExecutor executorService1 = new ThreadPoolExecutor(2, 50,
                100L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(50), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    executorService1.submit(
                            () -> {
                                synchronized (countDownLatch) {
                                    try {
                                        countDownLatch.await(); //一直阻塞当前线程，直到计时器的值为0,保证同时并发
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println(Thread.currentThread().hashCode()+"--"+Thread.currentThread().getName());
                                /*//每个线程增加1000次，每次加1
                                for (int j = 0; j < 1000; j++) {
                                    atomicInteger.incrementAndGet();
                                }*/
                                }
                            });
                }else {
                    executorService1.submit(() -> {
                        System.out.println("--"+Thread.currentThread().hashCode()+"--"+Thread.currentThread().getName());
                    });
                }
                countDownLatch.countDown();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        concurrenceTest();
    }
}

