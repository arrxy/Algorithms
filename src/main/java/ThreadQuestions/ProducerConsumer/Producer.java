package ThreadQuestions.ProducerConsumer;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue buffer;
    private String name;

    private Semaphore forProducer;
    private Semaphore forConsumer;

    public Producer(Queue queue, String name, Semaphore forProducer, Semaphore forConsumer) {
        this.buffer = queue;
        this.name = name;
        this.forProducer = forProducer;
        this.forConsumer = forConsumer;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            forProducer.acquire();
            buffer.add(new UnitOfWork());
            System.out.println(name +" : produced");
            forConsumer.release();
        }
    }
}
