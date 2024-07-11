package com.ivan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LongAddrTest {
    public static void main(String[] args) {

        demo(
                ()-> new AtomicLong(0),
                (addr) -> addr.getAndIncrement()
        );
        demo(
                ()-> new LongAdder(),
                (adder) -> adder.increment()
        );
    }

    public static <T> void demo(Supplier<T> addrSupplier, Consumer<T> action){
        T addr = addrSupplier.get();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 5_000_000; j++) {
                    action.accept(addr);
                }
            }));
        }
        long start = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        long end = System.nanoTime();
        System.out.println(addr + "cost time "+ (end - start)/1000_000);

    }
}
