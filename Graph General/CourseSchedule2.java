// ? https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150

// ! Course Schedule II
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]

import java.util.*;

public class CourseSchedule2 {

    // using DFS to get topological order
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] pre : prerequisites) {
                graph.get(pre[1]).add(pre[0]); // b → a
            }

            int[] state = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
            List<Integer> postOrder = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                if (state[i] == 0) {
                    if (!dfs(i, graph, state, postOrder)) {
                        return new int[0]; // cycle found
                    }
                }
            }

            // Reverse postOrder to get correct order
            Collections.reverse(postOrder);
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = postOrder.get(i);
            }
            return result;
        }

        private boolean dfs(int node, List<List<Integer>> graph, int[] state, List<Integer> postOrder) {
            if (state[node] == 1)
                return false; // found visiting → cycle
            if (state[node] == 2)
                return true; // already done

            state[node] = 1; // mark visiting
            for (int nei : graph.get(node)) {
                if (!dfs(nei, graph, state, postOrder)) {
                    return false;
                }
            }
            state[node] = 2; // mark visited
            postOrder.add(node);
            return true;
        }

    }

    // using BFS (Kahn's Algorithm) to get topological order
    // public class solution {
    //     public int[] findOrder(int numCourses, int[][] prerequisites) {
    //         List<List<Integer>> graph = new ArrayList<>();
    //         int[] indegree = new int[numCourses];
    //         for (int i = 0; i < numCourses; i++) {
    //             graph.add(new ArrayList<>());
    //         }
    //         for (int[] pre : prerequisites) {
    //             int a = pre[0], b = pre[1];
    //             graph.get(b).add(a); // b → a
    //             indegree[a]++;
    //         }

    //         Queue<Integer> q = new LinkedList<>();
    //         for (int i = 0; i < numCourses; i++) {
    //             if (indegree[i] == 0) {
    //                 q.offer(i);
    //             }
    //         }

    //         int[] result = new int[numCourses];
    //         int idx = 0;

    //         while (!q.isEmpty()) {
    //             int u = q.poll();
    //             result[idx++] = u;

    //             for (int v : graph.get(u)) {
    //                 indegree[v]--;
    //                 if (indegree[v] == 0) {
    //                     q.offer(v);
    //                 }
    //             }
    //         }

    //         if (idx == numCourses) {
    //             return result;
    //         } else {
    //             return new int[0]; // cycle present
    //         }
    //     }
    // }

    public static void main(String[] args) {
        CourseSchedule2 outer = new CourseSchedule2();
        Solution solution = outer.new Solution();

        // Test Case
        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] order = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order)); // Possible output: [0, 1, 2, 3] or [0, 2, 1, 3]
    }
}