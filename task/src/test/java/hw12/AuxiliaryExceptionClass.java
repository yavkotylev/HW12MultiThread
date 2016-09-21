package hw12;

/**
 * Created by Yaroslav on 20.09.16.
 */
class AuxiliaryExceptionClass implements Runnable {
    private final Task<String> task;

    public AuxiliaryExceptionClass(Task<String> task) {
        this.task = task;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " get value = " + task.get());
            throw new Exception();
        } catch (RuntimeException e) {
            System.out.println("Exception \'" + e.getMessage() + "\' received - OK");
        } catch (Exception e) {
            throw new RuntimeException("Unexpected behavior");
        }
    }
}
