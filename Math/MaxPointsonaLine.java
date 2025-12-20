// ? https://leetcode.com/problems/max-points-on-a-line/description/?envType=study-plan-v2&envId=top-interview-150

//! 149. Max Points on a Line
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

// Example 1:
// Input: points = [[1,1],[2,2],[3,3]]
// Output: 3

import java.util.*;

public class MaxPointsonaLine {
    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2)
                return n;

            // result
            int res = 0;

            for (int i = 0; i < n; i++) {

                Map<String, Integer> map = new HashMap<>();
                int duplicate = 1;
                int currMax = 0;

                int x1 = points[i][0];
                int y1 = points[i][1];

                for (int j = i + 1; j < n; j++) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    if (x2 == x1 && y2 == y1) {
                        duplicate++;
                        continue;
                    }

                    int dy = y2 - y1;
                    int dx = x2 - x1;

                    int g = gcf(dx, dy);
                    dy /= g;
                    dx /= g;

                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    if (dx == 0)
                        dy = 1;
                    if (dy == 0)
                        dx = 1;

                    String slope = dy + "/" + dx;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);

                    currMax = Math.max(currMax, map.get(slope));
                }
                res = Math.max(res, currMax + duplicate);
            }
            return res;
        }

        int gcf(int a, int b) {
            if (b == 0)
                return Math.abs(a);
            return gcf(b, a % b);
        }
    }
}
