import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorservice = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for(int i = 0; i < 1000; i++) {
            executorservice.submit(() -> counter.increment());
        }

        executorservice.shutdown();
        executorservice.awaittermination(60, TimeUnit.SECONDS);
    
        System.out.println("Final count is : " + counter.getCount());
    }
}
