package ThreadQuestions.ProducerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Runner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");
    public static void main(String[] args) {
        Queue<UnitOfWork> buffer = new ArrayDeque<>();
        int maxSize = 10;

        Set<Producer> producers = producerNames
                .stream()
                .map(name -> new Producer(buffer, maxSize, name))
                .collect(Collectors.toSet());

        Set<Consumer> consumers = consumerNames
                .stream()
                .map(name -> new Consumer(buffer, name))
                .collect(Collectors.toSet());

        producers.forEach(producer -> new Thread(producer).start());
        consumers.forEach(consumer -> new Thread(consumer).start());
    }
}
