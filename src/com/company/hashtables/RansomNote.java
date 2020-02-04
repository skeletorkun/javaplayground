package com.company.hashtables;

import com.company.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RansomNote {


    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        List<String> magazineList = Arrays.asList(magazine);
        List<String> noteList = Arrays.asList(note);
        if(magazineList.size() < noteList.size()){

            System.out.println("No");
            return;
        }
        else if(magazineList.size() == noteList.size()){
            Collections.sort(magazineList);
            Collections.sort(noteList);
            boolean missing = !magazineList.toString().equals(noteList.toString());

            System.out.println(missing ? "No" : "Yes");
            return;
        }

        HashMap<String, Integer> magazineFreqs = new HashMap<>();
        HashMap<String, Integer> noteFreqs = new HashMap<>();
        noteList.stream().distinct().forEach(w -> noteFreqs.put(w, Collections.frequency(noteList, w)));
        magazineList.stream().distinct().forEach(w -> magazineFreqs.put(w, Collections.frequency(magazineList, w)));

        if (noteFreqs.size() > magazineFreqs.size()) {

            Main.println("No");
            return;
        }

        boolean missing = noteFreqs.entrySet().stream().anyMatch(entry -> !magazineFreqs.containsKey(entry.getKey()) || noteFreqs.get(entry.getKey()) > magazineFreqs.get(entry.getKey()));

        Main.println(missing ? "No" : "Yes");


    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";
        checkMagazine(note.split(" "), note.split(" "));

    }

}
