package zyj.yihong.jmh;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class JmhDemo1 {

    @Benchmark
    @BenchmarkMode({Mode.SingleShotTime})
    @Measurement(iterations = 2)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public String testStringAdd() {
        String a = "";
        for (int i = 0; i < 100; i++) {
            a += i;
        }
        return a;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhDemo1.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .result("test.json")
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
