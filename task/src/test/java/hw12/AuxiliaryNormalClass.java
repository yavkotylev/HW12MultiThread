package hw12;

/**
 * Created by Yaroslav on 20.09.16.
 */
class AuxiliaryNormalClass implements Runnable{
    private final Task<String> task;

    public AuxiliaryNormalClass(Task<String> task) {
        this.task = task;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " get value = " + task.get());
    }
}
