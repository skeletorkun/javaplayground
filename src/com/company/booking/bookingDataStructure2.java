package com.company.booking;

import com.company.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class bookingDataStructure2 {


    // Complete the sort_hotels function below.
    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {

        List<String> keywordsList = Arrays.asList(keywords.split(" "))
                .stream().map(s -> s.replace(",", "")
                        .replace(".", "")
                        .toLowerCase()
        ).collect(Collectors.toList());

        HashMap<Integer, Integer> idsWithRankings = new HashMap<>();

        for (int i = 0; i < hotel_ids.size(); i++) {
            List<String> reviewWords = Arrays.asList(reviews.get(i).split(" ")).stream().map(
                    s -> s.replace(",", "")
                            .replace(".", "")
                            .toLowerCase()).collect(Collectors.toList());

            Integer ranking = rankHotel(keywordsList, reviewWords);
            Integer hotelId = hotel_ids.get(i);
            Integer existingRanking = idsWithRankings.get(hotelId);
            if(existingRanking != null){
                ranking = existingRanking + ranking;
            }

            idsWithRankings.put(hotelId, ranking);
        }

        Main.println(idsWithRankings);

        List<Integer> result = idsWithRankings.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.<Integer, Integer>comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Main.println(result);

        return result;
    }

    static Integer rankHotel(List<String> keywordsList, List<String> review){
        int ranking = 0;

        for(String word : review){
            if(keywordsList.contains(word)){
                ranking ++;
            }
        }
        return ranking;
    }


    public static void main(String[] args) {
       String keywords = "breakfast beach citycenter location metro view staff price";

       List<Integer> hotelIds = Arrays.asList(1, 1, 1, 2, 2, 3, 3);
        List<String> reviews = Arrays.asList("This hotel has a nice view of the citycenter. The location is perfect.",
                "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
        sort_hotels(keywords, hotelIds, reviews);
    }

}
