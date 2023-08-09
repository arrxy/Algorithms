package ThreadQuestions.AdderSubtractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;
    private Lock lock;
    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10000; ++i) {
            // critical section start
            lock.lock();
            int curVal = count.getCount();
            curVal += i;
            count.setCount(curVal);
            lock.unlock();
        }
    }
}
