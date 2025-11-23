// ? https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=top-interview-150

//! Evaluate Division
// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.

// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

// Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

// Example 1:
// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class EvaluateDivision {

    class Solution {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        double dfs(String current, String target, double value, Set<String> visited) {
            if (current.equals(target)) {
                return value;
            }

            visited.add(current);

            for (String neighbor : graph.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    double weight = graph.get(current).get(neighbor);
                    double result = dfs(neighbor, target, value * weight, visited);

                    if (result != -1.0) {
                        return result;
                    }
                }
            }

            return -1.0;
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            // Build graph
            for (int i = 0; i < equations.size(); i++) {
                String A = equations.get(i).get(0);
                String B = equations.get(i).get(1);
                double value = values[i];

                graph.putIfAbsent(A, new HashMap<>());
                graph.putIfAbsent(B, new HashMap<>());

                graph.get(A).put(B, value);       // A/B = value
                graph.get(B).put(A, 1.0 / value); // B/A = 1/value
            }

            double[] res = new double[queries.size()];

            // Answer queries
            for (int i = 0; i < queries.size(); i++) {
                String C = queries.get(i).get(0);
                String D = queries.get(i).get(1);

                if (!graph.containsKey(C) || !graph.containsKey(D)) {
                    res[i] = -1.0;
                } else {
                    Set<String> visited = new HashSet<>();
                    res[i] = dfs(C, D, 1.0, visited);
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision outer = new EvaluateDivision();
        Solution solution = outer.new Solution();

        // Test Case
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );

        double[] values = { 2.0, 3.0 };

        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a")
        );

        double[] result = solution.calcEquation(equations, values, queries);

        System.out.println("Results:");
        for (double val : result) {
            System.out.println(val);
        }
    }
}
