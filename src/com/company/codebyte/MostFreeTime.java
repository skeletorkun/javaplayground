package com.company.codebyte;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

import static com.company.Main.println;

public class MostFreeTime {

    static class Event {
        LocalTime start;
        LocalTime end;

        public Event(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalTime getStart() {
            return start;
        }

        public void setStart(LocalTime start) {
            this.start = start;
        }

        public LocalTime getEnd() {
            return end;
        }

        public void setEnd(LocalTime end) {
            this.end = end;
        }

        public int getStartInSecondOfDay(){
            return start.toSecondOfDay();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                    .add("start=" + start)
                    .add("end=" + end)
                    .toString();
        }

    }

    public static String MostFreeTime(List<String> times) {

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mma");

        List<Event> events = new ArrayList<>();
        for(String periods : times){

            String[] split = periods.split("-");
            if(split.length == 2){

                LocalTime time1 = LocalTime.parse(split[0], pattern);
                LocalTime time2 = LocalTime.parse(split[1], pattern);
                println(time1);
                println(time2);
                events.add(new Event(time1, time2));
            }
        }

        // return if there are less than 2 events
        if(events.size() < 2){
            return "00:00";
        }

        events.sort(Comparator.comparingInt(Event::getStartInSecondOfDay));

        Duration maxDurationBetween = Duration.ZERO;
        for (int i = 1; i < events.size(); i++) {
            Duration between = Duration.between(events.get(i -1).getEnd(), events.get(i).getStart());
            println(between);
            println("between " + between);

            if(maxDurationBetween.toMillis() < between.toMillis()){
                maxDurationBetween = between;
                println("maxDurationBetween " + maxDurationBetween);

            }
        }

        return String.format("%02d:%02d", maxDurationBetween.toHours(), maxDurationBetween.toMinutes()%60);
    }


    public static void main(String[] args) {
        List<String> times = Arrays.asList("10:00AM-12:30PM", "02:00PM-02:45PM", "09:10AM-09:50AM");
        println(MostFreeTime(times));
    }

}
