package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode #2895. Minimum Processing Time
 *
 * You have n processors each having 4 cores and n * 4 tasks that need to be executed such that each core should perform only one task.
 *
 * Given a 0-indexed integer array processorTime representing the time at which each processor becomes available for the first time
 * and a 0-indexed integer array tasks representing the time it takes to execute each task,
 * return the minimum time when all of the tasks have been executed by the processors.
 */
public class MinProcessingTime {

    // Procedure
    // P1. sort processorTime and tasks list in ascending order.
    // P2. calculate the time for the longest task for each processor.
    // P3. obtain the value for the task that takes the longest time.
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {

        Collections.sort(processorTime);
        Collections.sort(tasks);
        int maxTime = 0;

        for (int i = 0; i < processorTime.size(); i++) {
            if (processorTime.get(i) + tasks.get(tasks.size() - i * 4 -1) > maxTime)
                maxTime = processorTime.get(i) + tasks.get(tasks.size() - i * 4 -1);
        }

        return maxTime;

    }

    @Test
    public void checkCase() {

        List<Integer> processorTime = new ArrayList<>();
        processorTime.add(8);
        processorTime.add(10);

        int[] tasksArray = new int[]{2,2,3,1,8,7,4,5};
        List<Integer> tasks = new ArrayList<>();
        tasks = Arrays.asList(toIntegerArray(tasksArray));
        assert minProcessingTime(processorTime, tasks) == 16;

        processorTime = new ArrayList<>();
        processorTime.add(10);
        processorTime.add(20);

        int[] tasksArray2 = new int[]{2,3,1,2,5,8,4,3};
        List<Integer> tasks2 = new ArrayList<>();
        tasks2 = Arrays.asList(toIntegerArray(tasksArray));
        assert minProcessingTime(processorTime, tasks) == 23;


    }

    private static Integer[] toIntegerArray(int[] intArray) {
        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = intArray[i];
        }
        return result;
    }

}
