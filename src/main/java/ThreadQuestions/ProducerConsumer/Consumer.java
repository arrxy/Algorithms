package ThreadQuestions.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<UnitOfWork> buffer;
    private String name;

    public Consumer(Queue<UnitOfWork> buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }
    @Override
    public void run() {
        while (true) {
            if (!buffer.isEmpty()) {
                buffer.remove();
                System.out.println(name + " :consumed");
            }
        }
    }
}
