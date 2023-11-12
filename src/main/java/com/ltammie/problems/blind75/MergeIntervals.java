package com.ltammie.problems.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @No 56
 * sort intervals
 * compare end of left interval to the start of right interval, if start > end -> merge both
 */

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int currentMinPoint = intervals[i][0];
            int currentMaxPoint = intervals[i][1];
            // if they overlap we merge them and continue to the next interval
            if (currentMinPoint <= end) {
                if (currentMinPoint < start && currentMaxPoint > end) {
                    result.add(new int[]{currentMinPoint, currentMaxPoint});
                } else if (currentMaxPoint > end) {
                    end = currentMaxPoint;
                } else if (currentMinPoint < start) {
                    start = currentMinPoint;
                }
            } else { // if not, we add interval[start, end] to result
                result.add(new int[]{start, end});
                start = currentMinPoint;
                end = currentMaxPoint;
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
