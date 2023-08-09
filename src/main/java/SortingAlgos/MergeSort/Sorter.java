package SortingAlgos.MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> values = new ArrayList<>();

    private ExecutorService executorService;

    public Sorter(List<Integer> values, ExecutorService executorService) {
        this.values = values;
        this.executorService = executorService;
    }


    @Override
    public List<Integer> call() throws Exception {
        if (values.size() <= 1) {
            return values;
        }
        int mid = values.size() / 2;
        List<Integer> leftArray = values.subList(0, mid);
        List<Integer> rightArray = values.subList(mid, values.size());
        Future<List<Integer>> leftSorted = executorService.submit(new Sorter(leftArray, executorService));
        Future<List<Integer>> rightSorted = executorService.submit(new Sorter(rightArray, executorService));
        return merge(leftSorted, rightSorted);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture)
            throws InterruptedException, ExecutionException {
        List<Integer> sortedArray = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        // Compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
            // If left is smaller, add to sorted array
            // increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedArray.add(sortedLeft.get(first));
                ++first;
            } else {
                // Add the right one to the sorted array
                // increment second
                sortedArray.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
            sortedArray.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
            sortedArray.add(sortedRight.get(second));
            ++second;
        }

        return sortedArray;
    }

}