package org.sarace.codewars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StatForAthleticAssociassion {

    public static String computeStat(String timeList){
        if(timeList != null && !timeList.isEmpty()){
            return safeComputeStat(timeList);
        }
        return timeList;
    }

    private static String safeComputeStat(String timeList) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH|mm|ss");
        String resultToFormat = "Range: %s Average: %s Median: %s";
        String[] timeByPeopleAsString = timeList.split(", ");
        List<Long> timeByPeopleAsMili = Arrays.stream(timeByPeopleAsString).map(sDate -> {
            try {
                return formatter.parse(sDate).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        Collections.sort(timeByPeopleAsMili);
        String range = formatter.format(Collections.max(timeByPeopleAsMili) - Collections.min(timeByPeopleAsMili));
        String average = formatter.format(timeByPeopleAsMili.stream().mapToLong(l -> l).sum() / timeByPeopleAsMili.size());
        Long medianAsLong = null;
        if(timeByPeopleAsMili.size() % 2 == 0){
            medianAsLong = (timeByPeopleAsMili.get(timeByPeopleAsMili.size() / 2)
                    + timeByPeopleAsMili.get(timeByPeopleAsMili.size() / 2 - 1)) / 2;
        } else {
            medianAsLong = timeByPeopleAsMili.get(timeByPeopleAsMili.size() / 2);
        }
        String median = formatter.format(medianAsLong);
        String result = String.format(resultToFormat, range, average, median);
        return result;
    }
}
