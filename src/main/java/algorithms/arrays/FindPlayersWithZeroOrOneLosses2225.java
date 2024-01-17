package algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindPlayersWithZeroOrOneLosses2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> mapPlayerWithLossesResult = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            var winner = matches[i][0];
            var loser = matches[i][1];
            mapPlayerWithLossesResult.put(winner, mapPlayerWithLossesResult.getOrDefault(winner, 0));
            mapPlayerWithLossesResult.put(loser, mapPlayerWithLossesResult.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        var oneLosses = mapPlayerWithLossesResult.entrySet()
                .stream()
                .filter(v -> v.getValue() <= 1)
                .map(Map.Entry::getKey)
                .toList();
        result.add(oneLosses);
        return result;
    }
}
