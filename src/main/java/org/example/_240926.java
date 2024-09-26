package org.example;

import java.util.function.Function;

public class _240926 {

    public int differenceOfSum(int[] nums) {
        int x = 0, y = 0;
        for (int num : nums) {
            x += num;
            y += gao(num);
        }
        return Math.abs(x - y);
    }

    private int gao(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

}
