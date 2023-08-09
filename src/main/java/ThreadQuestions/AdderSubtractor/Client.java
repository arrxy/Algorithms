package ThreadQuestions.AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Count count = new Count();

        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);
        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(count.getCount());
    }
}
