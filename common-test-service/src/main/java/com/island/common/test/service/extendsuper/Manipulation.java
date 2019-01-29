package com.island.common.test.service.extendsuper;


// Manipulation.java
class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        // obj.f();
    } // 编译错误
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator(hf);
        manipulator.manipulate();
    }
}
