// ? https://leetcode.com/problems/ipo/description/?envType=study-plan-v2&envId=top-interview-150

// ! 502. IPO
// Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
// You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
// Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
// Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
// The answer is guaranteed to fit in a 32-bit signed integer. 

// Example 1:
// Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
// Output: 4

import java.util.*;

public class IPO {

    // ? using sorting + max-heap
    // class Solution {
    //     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //         int n = profits.length;

    //         // Step 1: Sort projects by capital required
    //         int[][] projects = new int[n][2];
    //         for (int i = 0; i < n; i++) {
    //             projects[i][0] = capital[i];
    //             projects[i][1] = profits[i];
    //         }
    //         Arrays.sort(projects, (a, b) -> a[0] - b[0]);
    //         // Max-heap of profits only
    //         PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);

    //         int idx = 0;

    //         // Step 2: Run up to k selections
    //         while (k-- > 0) {

    //             // Add all affordable projects to max-heap
    //             while (idx < n && projects[idx][0] <= w) {
    //                 maxProfit.offer(projects[idx][1]);
    //                 idx++;
    //             }

    //             // If no affordable project exists, stop early
    //             if (maxProfit.isEmpty())
    //                 break;

    //             // Choose the highest-profit project
    //             w += maxProfit.poll();
    //         }

    //         return w;
    //     }
    // }

    // ? using two heaps
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = capital.length;
            // sort for capital
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            // sort for profit
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

            for (int i = 0; i < n; i++) {
                minHeap.offer(new int[] { capital[i], profits[i] });
            }

            for (int i = 0; i < k; i++) {

                while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                    maxHeap.offer(minHeap.poll());
                }
                if (maxHeap.isEmpty()) {
                    break;
                }

                w += maxHeap.poll()[1];
            }
            return w;
        }
    }

    public static void main(String[] args) {
        Solution solution = new IPO().new Solution();
        int k = 2;
        int w = 0;
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        int result = solution.findMaximizedCapital(k, w, profits, capital);
        System.out.println(result); // Output: 4
    }
}
