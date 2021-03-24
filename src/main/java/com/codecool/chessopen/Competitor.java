package com.codecool.chessopen;

import java.util.List;

public class Competitor {
    private final String name;
    private final List<Integer> results;

    public Competitor(String name, List<Integer> results) {
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
