import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    private static int pause = 2500;

    private int messageNumber;
    private String name;


    public CallableTask(int messageNumber, String taskName) {
        this.messageNumber = messageNumber;
        name = taskName;
    }

    @Override
    public Integer call() throws Exception {
        Thread.currentThread().setName("Thread of " + name);
        Integer messageCounter = 0;
        try {
            while (messageCounter < messageNumber) {
                Thread.sleep(pause);
                System.out.printf("Hello! I'm %s!\n", Thread.currentThread().getName());
                messageCounter++;
            }
        } catch (InterruptedException e) {
        }
        return messageCounter;
    }
}
