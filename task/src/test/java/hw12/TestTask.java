package hw12;

import junit.framework.TestCase;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class TestTask extends TestCase {

    public void testTaskException() throws InterruptedException {
        System.out.println("Exception test start");
        Task<String> task = new Task<String>(new TestExceptionCallable());
        Thread a = new Thread(new AuxiliaryExceptionClass(task));
        a.start();
        new Thread(new AuxiliaryExceptionClass(task)).start();
        new Thread(new AuxiliaryExceptionClass(task)).start();
        new Thread(new AuxiliaryExceptionClass(task)).start();
        new Thread(new AuxiliaryExceptionClass(task)).start();
        Thread.sleep(1000);
        System.out.println("Exception test end\n\n");
    }

    public void testTaskNormalWork() {
        System.out.println("Normal working test start");
        Task<String> task = new Task<String>(new TestOKCallable(3000));
        Thread a = new Thread(new AuxiliaryNormalClass(task));
        a.start();
        new Thread(new AuxiliaryNormalClass(task)).start();
        new Thread(new AuxiliaryNormalClass(task)).start();
        new Thread(new AuxiliaryNormalClass(task)).start();
        new Thread(new AuxiliaryNormalClass(task)).start();
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Normal working test end");
    }
}

