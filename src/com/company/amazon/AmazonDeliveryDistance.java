package com.company.amazon;

import com.company.Main;

import java.util.*;

public class AmazonDeliveryDistance {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        List<Location> list = new ArrayList<>();

        for(List<Integer> location : allLocations){
            Double distance = calculateDistance(0, 0, location.get(0), location.get(1));
            list.add(new Location(distance, location));
        }

        Collections.sort(list, (l1, l2) -> Double.compare(l1.distance, l2.distance));

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< numDeliveries; i++){
            result.add(list.get(i).location);
        }
        return result;

    }
    // METHOD SIGNATURE ENDS

    class Location{
        Double distance;
        List<Integer> location;
        Location(Double d, List<Integer> l){
            distance=d;
            location=l;
        }
    }

    private Double calculateDistance(int beginX, int beginY, int x, int y){
        return Math.sqrt(Math.pow((beginX - x), 2) +  Math.pow((beginY - y), 2));
    }

    public static void main(String[] args) {

//        int maxTravelDist = 20;
//        List<List<Integer>> forwardRouteList = new ArrayList<>();
//        forwardRouteList.add(Arrays.asList(1, 8));
//        forwardRouteList.add(Arrays.asList(2, 7));
//        forwardRouteList.add(Arrays.asList(3, 14));
//
//        List<List<Integer>> returnRouteList= new ArrayList<>();
//        returnRouteList.add(Arrays.asList(1, 5));
//        returnRouteList.add(Arrays.asList(2, 10));
//        returnRouteList.add(Arrays.asList(3, 14));
//
//        AmazonDeliveryDistance problem = new AmazonDeliveryDistance();
//        List<List<Integer>> lists = problem.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);
//        Main.println(lists.toString());

    }
}
