package leetcode.catAndMouseGame;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution2 {
    public int[][] graph;
    final GameState initialState = new GameState(1, 2, Player.Mouse);

    public int catMouseGame(int[][] graph) {
        this.graph = graph;

        Map<GameState, Player> cache = new HashMap<>();
        final Set<GameState> statesToAnalyse = new HashSet<>();
        generateWinStates(cache);
        cache.forEach((gameState, player) -> statesToAnalyse.addAll(gameState.possibleStatesFrom()));

        while (!statesToAnalyse.isEmpty()){
            Set<GameState> newStatesToAnalyse = statesToAnalyse.stream()
                .flatMap(gameState -> {
                        Player definedWinner = definedWinner(gameState, cache);
                        if (definedWinner != Player.None && !cache.containsKey(gameState)) {
                            cache.put(gameState, definedWinner);
                            return gameState.possibleStatesFrom().stream();
                        } else
                            return Stream.empty();
                    }
                ).collect(Collectors.toSet());
            newStatesToAnalyse.removeIf(cache::containsKey);
            statesToAnalyse.clear();
            statesToAnalyse.addAll(newStatesToAnalyse);
        }
        return cache.getOrDefault(initialState, Player.None).label;
    }

    public void generateWinStates(Map<GameState, Player> cache){
        //TODO
    }

    public Player definedWinner(GameState gameState, Map<GameState, Player> cache){
        cache.clear();
        return null; //TODO
    }

    enum E{E1, E2, E3}

    enum Player {
        Cat(2), Mouse(1), None(0);

        public final int label;

        public static Player opposite(Player player){
            return null; //TODO
        }

        Player(int label) {
            this.label = label;
        }
    }

    public class GameState {
        final int mouseNode;
        final int catNode;
        final Player currentTurn;

        public GameState(int mouseNode, int catNode, Player currentTurn) {
            this.mouseNode = mouseNode;
            this.catNode = catNode;
            this.currentTurn = currentTurn;
        }

        public Collection<GameState> possibleStatesTo(){
            return null; //TODO
        }

        public Collection<GameState> possibleStatesFrom(){
            return null; //TODO
        }

        public Player defineWinner(){ //maye cache?
            return null; //TODO
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameState gameState = (GameState) o;
            return mouseNode == gameState.mouseNode &&
                catNode == gameState.catNode &&
                currentTurn == gameState.currentTurn;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mouseNode, catNode, currentTurn);
        }
    }
}
