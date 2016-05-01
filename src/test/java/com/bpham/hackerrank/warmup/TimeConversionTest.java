package com.bpham.hackerrank.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeConversionTest {

    @Test
    public void shouldConvertPMToMilitaryTime() {
        String inputTime = "07:05:45";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "PM");

        assertEquals("19:05:45", result);
    }

    @Test
    public void shouldConvertAMToMilitaryTime() {
        String inputTime = "07:05:45";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "AM");

        assertEquals("07:05:45", result);
    }

    @Test
    public void shouldNotAdd12HoursTo12PM() {
        String inputTime = "12:05:45";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "PM");

        assertEquals("12:05:45", result);
    }

    @Test
    public void shouldNotAdd12HoursTo12AM() {
        String inputTime = "12:00:00";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "AM");

        assertEquals("00:00:00", result);
    }

    @Test
    public void shouldNotAdd12HoursTo1AM() {
        String inputTime = "01:00:00";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "AM");

        assertEquals("01:00:00", result);
    }

    @Test
    public void shouldAdd12HoursTo1PM() {
        String inputTime = "01:00:00";

        String result = TimeConversion.convertToMilitaryTime(inputTime, "PM");

        assertEquals("13:00:00", result);
    }
}
