package com.island.common.test.service.pipeline;

public interface Valve {
    public Valve getNext();
    public void setNext(Valve valve);
    public void invoke(String handling);
  }


