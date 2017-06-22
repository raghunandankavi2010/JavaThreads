/**
 * Created by raghu on 21/6/17.
 */


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ParallelTest {


    public static void main(String[] args) throws InterruptedException {

        doSomething2();

        waitSleep();

   
    }

    public static void waitSleep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try for printing abc abc with each a, b and c on a different thread
     */
    static int x = 0;

    private static void doSomething2() {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Scheduler scheduler = Schedulers.from(executor);
        Observable.range(1, 3)
                .concatMap(new Function<Integer, ObservableSource<? extends Integer>>() {
                               @Override
                               public ObservableSource<? extends Integer> apply(Integer i) throws Exception {
                                   return Observable.just(i)
                                           .subscribeOn(scheduler)
                                           .map(new Function<Integer, Integer>() {
                                               @Override
                                               public Integer apply(Integer i2) throws Exception {
                                                   System.out.println("Calculating " + i2 + " on " + Thread.currentThread().getName());
                                                   return i2;
                                               }
                                           });
                               }
                           }
                ).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                scheduler.shutdown();
                System.out.println("Finally");
                x++;
                Thread.sleep(100);
                if (x != 10) {
                    doSomething2();
                }
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });
    }
}

