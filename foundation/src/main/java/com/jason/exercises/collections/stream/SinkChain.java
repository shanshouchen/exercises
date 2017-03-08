package com.jason.exercises.collections.stream;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/14.
 */
public class SinkChain {
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4, 5};
        Spliterator spliterator = Arrays.stream(source).spliterator();
        Sink<Integer> sink0 = new Sink<>(null, "source sink");
        Sink<Integer> sink4 = sink0.op("sink1").op("sink2").op("sink3").op("terminal sink");
        Sink wappedSink = wrapSink(sink4);
        assert (wappedSink == sink0);

        spliterator.forEachRemaining(wappedSink);

    }

    public static Sink wrapSink(Sink sink) {
        while (sink.upstream != null) {
            sink.upstream.downStream = sink;
            sink = sink.upstream;
        }
        return sink;
    }

    static class Sink<T> implements Consumer<T> {
        private Sink upstream;
        private Sink downStream;
        private String name;

        public Sink(Sink upstream, String name) {
            this.upstream = upstream;
            this.name = name;
        }

        public Sink op(String name) {
            return new Sink(this, name);
        }

        @Override
        public void accept(T t) {
            System.out.println(name + " handlers " + t);
            if (downStream != null)
                downStream.accept(t);
        }
    }
}
