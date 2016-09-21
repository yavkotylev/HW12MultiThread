package hw12;

import java.util.concurrent.Callable;

/**
 * Created by Yaroslav on 20.09.16.
 */
public class TestExceptionCallable implements Callable<String> {
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " run call()");
        throw new Exception("Something wrong");
    }
}
