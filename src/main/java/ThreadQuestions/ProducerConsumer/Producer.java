package ThreadQuestions.ProducerConsumer;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue buffer;
    private Integer maxSize;
    private String name;

    public Producer(Queue queue, Integer maxSize, String name) {
        this.buffer = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (buffer.size() < maxSize) {
                buffer.add(new UnitOfWork());
                System.out.println(name +" : produced");
            }
        }
    }
}
