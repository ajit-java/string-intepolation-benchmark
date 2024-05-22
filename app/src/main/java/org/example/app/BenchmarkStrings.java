package org.example.app;
import org.openjdk.jmh.annotations.*;


import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode({Mode.Throughput})
@Warmup(iterations = 10)
@Fork(value = 1)
@State(Scope.Benchmark)
public class BenchmarkStrings {
     private static final int LOOPS = 1000;
    
        @Benchmark
        public int testOld() {
            int counter = 0;
            for (int i = 0; i < LOOPS; i++) {
                String s = "What do you get if you multiply " + counter + " by " + counter + "?";
                counter += s.length();
            }
            return counter;
        }
    
        @Benchmark
        public int testNew() {
            int counter = 0;
            for (int i = 0; i < LOOPS; i++) {
                String s = String.format("What do you get if you multiply %d by %d?", counter, counter);
                counter += s.length();
            }
            return counter;
        }
}
