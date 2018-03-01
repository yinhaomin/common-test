package com.island.common.test.service.reference;

import lombok.Data;

@Data
public class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

}
