package org.example;

import java.util.*;

public class huaweibishi {

    public static void main(String[] args) {
        var cin = new Scanner(System.in);

        int n = cin.nextInt(), m = cin.nextInt();

        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = cin.nextInt();
        }

        int[] cycleDays = new int[2 * n];
        System.arraycopy(days, 0, cycleDays, 0, n);
        System.arraycopy(days, 0, cycleDays, n, n);

        System.out.println(gao(2 * n, m, cycleDays));
    }

    public static long gao(int n, int x, int[] days) {
        long totalCoins = 0;
        int startMonth = 0, startDay = 1, endMonth = 0, endDay = 1;

        int daysCovered = 0;
        while (daysCovered < x && endMonth < n) {
            if (endDay == 1 && daysCovered + days[endMonth] <= x) {
                totalCoins += (1 + days[endMonth]) * (long) days[endMonth] / 2;
                daysCovered += days[endMonth];
                endMonth++;
            } else {
                if (endDay <= days[endMonth]) {
                    totalCoins += endDay;
                    daysCovered++;
                    endDay++;
                }
                if (endDay > days[endMonth]) {
                    endMonth++;
                    endDay = 1;
                }
            }
        }

        long maxCoins = totalCoins;
        while (endMonth < n) {
            int leftShift = days[startMonth] - startDay + 1;
            int rightShift = days[endMonth] - endDay + 1;

            int shiftStep = Math.min(leftShift, rightShift);
            totalCoins += (long) (endDay - startDay) * shiftStep;
            maxCoins = Math.max(maxCoins, totalCoins);

            startDay += shiftStep; endDay += shiftStep;

            if (startDay > days[startMonth]) {
                startMonth++; startDay = 1;
            }
            if (endDay > days[endMonth]) {
                endMonth++; endDay = 1;
            }
        }

        return maxCoins;
    }

}
