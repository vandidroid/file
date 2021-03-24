package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {
        List<Competitor> competitors = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            String[] data;
            String name;
            List<Integer> results;

            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");

                name = data[0];

                results = new ArrayList<>();

                for (int i = 1; i < data.length; i++) {
                    results.add(Integer.parseInt(data[i]));
                }

                competitors.add(new Competitor(name, results));
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }

        return competitors.stream().sorted((a, b) -> b.getTotalPoints() - a.getTotalPoints()).map(a -> a.getName()).collect(Collectors.toList());
    }

}
