package com.ivan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_7 {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long reverse = 0;
        int temp = x;
        List<Integer> list = new ArrayList();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int length = list.size();
        for (int i = 0; i < length; i++) {
            reverse = reverse * 10 + list.get(i);
        }
        if (reverse < min || reverse > max) {
            return 0;
        }
        return Math.toIntExact(reverse);
    }
}
