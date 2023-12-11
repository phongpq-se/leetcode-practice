package algorithms;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("a", "hello");
        map.putIfAbsent("a", "hello1");
        map.values().forEach(v -> System.out.println(v));
        map.keySet().forEach(v -> System.out.println(v));
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    public double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = dfs(neighbour.getKey(), end, visited, graph);
                if (productWeight != -1.0) {
                    return neighbour.getValue() * productWeight;
                }
            }
        }
        return -1;
    }

    public Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;
        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, values[i]);
        }
        return graph;
    }
}
