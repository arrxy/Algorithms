package ThreadQuestions.ProducerConsumer;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<UnitOfWork> buffer;
    private String name;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    public Consumer(Queue<UnitOfWork> buffer, String name, Semaphore forProducer, Semaphore forConsumer) {
        this.buffer = buffer;
        this.name = name;
        this.forConsumer = forConsumer;
        this.forProducer = forProducer;
    }
    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            forConsumer.acquire();
            buffer.remove();
            System.out.println(name + " :consumed");
            forProducer.release();
        }
    }
}
