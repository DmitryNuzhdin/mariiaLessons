package leetcode.minimumCostForTickets;

import java.util.Arrays;

public class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int[] minCostForDay = new int[396];
        int lastDayOfJourney = days[days.length - 1];
        minCostForDay[lastDayOfJourney] = costs[0];
        for (int i = lastDayOfJourney; i >= 1; i--) {
            int day = i;
            if (Arrays.stream(days).anyMatch(k -> k == day)) {
                int sumCostIfBuyOneDayTicket = costs[0] + minCostForDay[day + 1];
                int sumCostIfBuyWeekTicket = costs[1] + minCostForDay[day + 7];
                int sumCostIfBuyMonthTicket = costs[2] + minCostForDay[day + 30];
                minCostForDay[day] = Math.min(Math.min(sumCostIfBuyOneDayTicket, sumCostIfBuyWeekTicket), sumCostIfBuyMonthTicket);
            } else {
                minCostForDay[day] = minCostForDay[day + 1];
            }
        }
        return minCostForDay[1];
    }

}