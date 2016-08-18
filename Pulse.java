package pulse;

import java.time.Duration;
import java.time.LocalDateTime;

import static pulse.StatData.getPulse;


public class Pulse {
    private static int day;
    private static int month;
    private static int year;
    private static int hours;
    private static int minutes;
    private static int age;
    private static LocalDateTime birthday;
    private static int sex;
    private static int condition;
    private static int years;

    public Pulse(int[] initParams) {
        day = initParams[0];
        month = initParams[1];
        year = initParams[2];
        hours = initParams[3];
        minutes = initParams[4];
        sex = initParams[5];
        condition = initParams[6];
        age = getAge();
        birthday = LocalDateTime.of(year, month, day, hours, minutes);
    }

    private int getAge() {
        LocalDateTime date = LocalDateTime.now();
        date = date.minusDays(day);
        date = date.minusMonths(month);
        date = date.minusYears(year);
        date = date.minusHours(hours);
        date = date.minusMinutes(minutes);
        return date.getYear();
    }

    public long getTotalPulse() {
        long totalPulse = 0;
        for (int periodNumber = 0; periodNumber < 9; periodNumber++) {
            if (age+1 > getPeriodLimit(periodNumber)[0])
                totalPulse += getPulseForPeriod(periodNumber);
        }
        return totalPulse;
    }

    private long[] getSecondsForYears() {
        long[] result = new long[age + 1];
        if (age < 1) {
            result[0] = Duration.between(birthday, birthday.plusYears(1)).getSeconds();
            return result;
        }
        long totalTimeOfLife = Duration.between(birthday, LocalDateTime.now()).getSeconds();
        long totalTimeOfWholeYears = 0;
        int index = 0;
        while (index < age) {
            result[index] = Duration.between(birthday.plusYears(index), birthday.plusYears(index + 1)).getSeconds();
            totalTimeOfWholeYears += result[index++];
        }
        result[age] = totalTimeOfLife - totalTimeOfWholeYears;
        return result;
    }

    private double getPulseForPeriod(int period) {
        long totalTime = 0;
        if (period == 0)
            return getSecondsForYears()[years++] / 60. * getPulse(sex, condition, period);
        if (age > 65) {
            while (years < age + 1) {
                totalTime += getSecondsForYears()[years++];
            }
        } else {
            while (years < age + 1 && years <= getPeriodLimit(period)[1]) {
                totalTime += getSecondsForYears()[years++];
            }
        }
        return totalTime / 60. * getPulse(sex, condition, period);
    }

    private int[] getPeriodLimit(int periodNumber) {
        int[] topLimit = {0, 1, 11, 18, 26, 36, 46, 56, 66};
        int[] downLimit = {1, 10, 17, 25, 35, 45, 55, 65, age};
        return new int[]{topLimit[periodNumber], downLimit[periodNumber]};
    }
}