package com.island.common.test.service.reference;

public class ReferenceTest {

    public static void main(String[] args) {
        Dog adai = null;
        adai = new Dog("Fifi");
        Dog bdai = null;
        bdai = new Dog("xxxx");
        // changeDog(adai);
        swap(adai, bdai);
        System.out.print(adai.getName());
    }

    public static void changeDog(Dog dog) {
        dog.setName("Max");
        // dog = new Dog("Max");
    }

    public static void swap(Dog arg1, Dog arg2) {
        Dog temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }

}
