package hw12;

/**
 * Created by Yaroslav on 21.09.16.
 */
class SimpleTask implements Runnable{
    private final int secondsToSleep;
    private final String message;

    public SimpleTask(int secondsToSleep, String message) {
        this.secondsToSleep = secondsToSleep;
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
