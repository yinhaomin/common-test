package com.island.common.test.service.pipeline;

public interface Pipeline {
    public Valve getFirst();

    public Valve getBasic();

    public void setBasic(Valve valve);

    public void addValve(Valve valve);
}
