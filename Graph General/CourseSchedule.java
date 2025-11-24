// ? https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150

//! Course Schedule
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    // ===================== DFS Solution =====================
    class SolutionDFS {
        List<List<Integer>> graph = new ArrayList<>();

        boolean dfs(int course, int[] state) {
            if (state[course] == 1) return false; // cycle
            if (state[course] == 2) return true;  // already visited

            state[course] = 1; // visiting

            for (int next : graph.get(course)) {
                if (!dfs(next, state)) return false;
            }

            state[course] = 2; // done
            return true;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // Initialize graph
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            // Build graph
            for (int[] pre : prerequisites) {
                int a = pre[0];
                int b = pre[1];
                graph.get(b).add(a);  // b → a
            }

            int[] state = new int[numCourses];

            // Run DFS for unvisited nodes
            for (int i = 0; i < numCourses; i++) {
                if (state[i] == 0) {
                    if (!dfs(i, state)) return false;
                }
            }

            return true;
        }
    }


    // ===================== BFS (Topological Sort) Solution =====================
    class SolutionBFS {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] indegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            // Build graph + indegree
            for (int[] pre : prerequisites) {
                int a = pre[0];
                int b = pre[1];

                graph.get(b).add(a); // b → a
                indegree[a]++;       // a depends on b
            }

            Queue<Integer> q = new LinkedList<>();

            // Add all courses with indegree 0
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            int count = 0;

            while (!q.isEmpty()) {
                int course = q.poll();
                count++;

                for (int next : graph.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            // If processed all courses → no cycle
            return count == numCourses;
        }
    }


    // ===================== MAIN METHOD =====================
    public static void main(String[] args) {

        CourseSchedule outer = new CourseSchedule();

        // 🔹 Test DFS version
        SolutionDFS dfsSolution = outer.new SolutionDFS();

        int numCourses = 4;

        int[][] prerequisites1 = {
            {1, 0},
            {2, 1},
            {3, 2}
        };

        System.out.println("DFS → Can finish? " + dfsSolution.canFinish(numCourses, prerequisites1));
        // Output: true


        // 🔹 Test BFS version
        SolutionBFS bfsSolution = outer.new SolutionBFS();

        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };

        System.out.println("BFS → Can finish? " + bfsSolution.canFinish(2, prerequisites2));
        // Output: false (cycle)
    }
}
