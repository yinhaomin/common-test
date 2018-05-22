package com.island.common.test.service.pipeline;

public class BasicValve implements Valve {
    protected Valve next = null;

    public Valve getNext() {
        return next;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("aa", "bb");
        System.out.println("基础阀门处理完后：" + handling);
    }

    public void setNext(Valve valve) {
        this.next = valve;
    }
}