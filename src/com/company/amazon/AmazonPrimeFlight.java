package com.company.amazon;

import com.company.Main;

import java.util.*;

public class AmazonPrimeFlight {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        // WRITE YOUR CODE HERE

        List<Pair> pairs = new ArrayList<>();

        for(int i=0; i<forwardRouteList.size(); i++){
            List<Integer> fwRoute = forwardRouteList.get(i);

            // skip if route length > maxTravelDist
            if(fwRoute.get(1) >= maxTravelDist){
                continue;
            }

            for(int j=0; j<returnRouteList.size(); j++){

                List<Integer> rtRoute = returnRouteList.get(j);

                // skip if route length > maxTravelDist
                if(rtRoute.get(1) >= maxTravelDist || rtRoute.get(1) + fwRoute.get(1) > maxTravelDist ){
                    continue;
                }

                pairs.add(new Pair(fwRoute, rtRoute));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> maxTravelDist - a.total));
        pq.addAll(pairs);

        List<List<Integer>> result = new ArrayList<>();
        Integer lastTotal = null;
        if (pq.peek() != null) {
            lastTotal = pq.peek().total;
        }
        while(pq.peek() != null){
            Pair pair = pq.poll();
            if(!(lastTotal).equals(pair.total))
            {
                break;
            }
            result.add(pair.getPairIds());
        }

        return result;
    }

    class Pair{
        // looks like [1, 2000]
        List<Integer> fwRoute;
        List<Integer> rtRoute;
        Integer total;

        Pair(List<Integer> f, List<Integer> r){
            fwRoute = f;
            rtRoute = r;
            total = f.get(1) + r.get(1);
        }

        public List<Integer> getPairIds(){
            return Arrays.asList(fwRoute.get(0), rtRoute.get(0));
        }

    }

    public static void main(String[] args) {

        int maxTravelDist = 20;
        List<List<Integer>> forwardRouteList = new ArrayList<>();
        forwardRouteList.add(Arrays.asList(1, 8));
        forwardRouteList.add(Arrays.asList(2, 7));
        forwardRouteList.add(Arrays.asList(3, 14));

        List<List<Integer>> returnRouteList= new ArrayList<>();
        returnRouteList.add(Arrays.asList(1, 5));
        returnRouteList.add(Arrays.asList(2, 10));
        returnRouteList.add(Arrays.asList(3, 14));

        AmazonPrimeFlight problem = new AmazonPrimeFlight();
        List<List<Integer>> lists = problem.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);
        Main.println(lists.toString());

    }
}
