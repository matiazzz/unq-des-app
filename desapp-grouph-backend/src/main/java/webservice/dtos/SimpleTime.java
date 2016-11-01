package webservice.dtos;

import org.joda.time.LocalTime;

public class SimpleTime {
    public int hours;
    public int minutes;

    public SimpleTime(LocalTime localTime) {
        hours = localTime.getHourOfDay();
        minutes = localTime.getMinuteOfHour();
    }
}
