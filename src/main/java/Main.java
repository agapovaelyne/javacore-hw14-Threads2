import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //part one
        Callable<Integer> callableOne = new CallableTask(1, "Task One");
        Callable<Integer> callableTwo = new CallableTask(2, "Task Two");
        Callable<Integer> callableThree = new CallableTask(3, "Task Three");
        Callable<Integer> callableFour = new CallableTask(4, "Task Four");

        final ExecutorService threadPool = Executors.newFixedThreadPool(4);

        final Future<Integer> taskOne = threadPool.submit(callableOne);
        final Future<Integer> taskTwo = threadPool.submit(callableTwo);
        final Future<Integer> taskThree = threadPool.submit(callableThree);
        final Future<Integer> taskFour = threadPool.submit(callableFour);

        final Integer taskOneRes = taskOne.get();
        final Integer taskTwoRes = taskTwo.get();
        final Integer taskThreeRes = taskThree.get();
        final Integer taskFourRes = taskFour.get();

        System.out.println();
        System.out.printf("Result of Task One: %d message(s)\n", taskOneRes);
        System.out.printf("Result of Task Two: %d message(s)\n", taskTwoRes);
        System.out.printf("Result of Task Three: %d message(s)\n", taskThreeRes);
        System.out.printf("Result of Task Four: %d message(s)\n", taskFourRes);

        //part two
        List<Callable<Integer>> taskList = new ArrayList<>();
        taskList.add(callableOne);
        taskList.add(callableTwo);
        taskList.add(callableThree);
        taskList.add(callableFour);

        System.out.println();
        Integer fastestResult = threadPool.invokeAny(taskList);
        System.out.printf("Result of the fastest task: %d message(s)\n", fastestResult);

        threadPool.shutdown();

    }
}
