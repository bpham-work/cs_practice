package com.bpham.hackerrank.warmup;

public class TimeConversion {
    public static String convertToMilitaryTime(String inputTime, String amOrPm) {
        String hours = inputTime.substring(0, 2);
        int hoursInt = Integer.parseInt(hours);
        if (amOrPm.equals("PM") && hoursInt < 12) {
            int militaryHours = hoursInt + 12;
            String resultingMilitaryHoursString = convertHoursIntToString(militaryHours);
            return inputTime.replaceFirst(hours, resultingMilitaryHoursString);
        } else if (amOrPm.equals("AM") && hoursInt == 12) {
            String resultingMilitaryHoursString = convertHoursIntToString(0);
            return inputTime.replaceFirst(hours, resultingMilitaryHoursString);
        } else {
            return inputTime;
        }
    }

    private static String convertHoursIntToString(int hours) {
        if (hours < 10) {
            return "0" + hours;
        } else {
            return Integer.toString(hours);
        }
    }
}
