package com.island.common.test.service.pipeline;

public class SecondValve implements Valve {
    protected Valve next = null;

    public Valve getNext() {
        return next;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("11", "22");
        System.out.println("Second阀门处理完后：" + handling);
        getNext().invoke(handling);
    }

    public void setNext(Valve valve) {
        this.next = valve;
    }
}