package com.island.common.test.service.lambda;

import java.util.List;

import com.google.common.collect.Lists;

public class IteratorLambda {

    public static void main(String[] args) {
        List<String> allArtists = Lists.newArrayList();
        long count = allArtists.stream().filter(artist -> artist.equals("大傻子")).count();
        System.out.println(count);
    }

}
