package com.flight.query.sequential;

import com.flight.query.Route;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

/**
 * Main class using optimized sequential query
 */
public class SequentialMain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input the start date (YYYY-MM-DD): ");
        String[] startArr = sc.nextLine().split("-");
        System.out.println("Input the end date (YYYY-MM-DD): ");
        String[] endArr = sc.nextLine().split("-");
        Date startDate = new Date(Integer.valueOf(startArr[0]) - 1900,
                Integer.valueOf(startArr[1]) - 1,
                Integer.valueOf(startArr[2]));
        Date endDate = new Date(Integer.valueOf(endArr[0]) - 1900,
                Integer.valueOf(endArr[1]) - 1,
                Integer.valueOf(endArr[2]));
        long startTime = System.currentTimeMillis();
        Set<Route> res = SequentialQuery.ttcQuery(startDate, endDate);
        long endTime = System.currentTimeMillis();

        for (Route route : res) {
            System.out.println(route.getDepAirport().getId() + " " + route.getDestAirport().getId());
        }

        System.out.println("Number of pairs: " + res.size());
        System.out.print("Time cost: ");
        System.out.print(endTime - startTime);
        System.out.println("ms");
    }
}
