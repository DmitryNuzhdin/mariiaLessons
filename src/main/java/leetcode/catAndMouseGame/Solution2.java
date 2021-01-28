package leetcode.catAndMouseGame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

            while (!statesToAnalyse.isEmpty()) {
                Set<GameState> newStatesToAnalyse = statesToAnalyse.stream()
                        .flatMap(gameState -> {
                                    Player definedWinner = definedWinner(gameState, cache);
                                    if (definedWinner != Player.None && !cache.containsKey(gameState)) {
                                        cache.put(gameState, definedWinner);
                                        gameState.printGameState(definedWinner);
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

        public void generateWinStates(Map<GameState, Player> cache) {
            int mouseWinNode = 0;
            int[] nodes = IntStream.range(1, graph.length).toArray();
            for (int i : nodes) {
                cache.put(new GameState(i, i, Player.Cat), Player.Cat);
                cache.put(new GameState(i, i, Player.Mouse), Player.Cat);
                cache.put(new GameState(mouseWinNode, i, Player.Cat), Player.Mouse);
                cache.put(new GameState(mouseWinNode, i, Player.Mouse), Player.Mouse);
            }

        }

        public Player definedWinner(GameState gameState, Map<GameState, Player> cache) {
            Collection<GameState> availableGameStates = gameState.possibleStatesTo();
            Collection<Player> winStates = new ArrayList<>();
            for (GameState availableGameState : availableGameStates) {
                Player gameExodus = cache.get(availableGameState);
                winStates.add(gameExodus != null ? gameExodus : Player.None);
            }
            if (winStates.contains(gameState.currentTurn)) {
                return gameState.currentTurn;
            } else if (winStates.contains(Player.None)) {
                return Player.None;
            } else {
                return gameState.currentTurn.opposite();
            }

        }

        enum Player {
            Cat(2), Mouse(1), None(0);

            public final int label;

            public Player opposite() {
                return this == Player.Cat ? Player.Mouse : Player.Cat;

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

            public Collection<GameState> possibleStatesTo() {
                int[] possibleStates = (currentTurn == Player.Mouse) ? graph[mouseNode] : graph[catNode];
                return Arrays.stream(possibleStates)
                        .boxed()
                        .filter(node -> node != 0 || currentTurn == Player.Mouse)
                        .map(node -> {
                                    if (currentTurn == Player.Mouse) {
                                        return new GameState(node, catNode, currentTurn.opposite());
                                    } else {
                                        return new GameState(mouseNode, node, currentTurn.opposite());
                                    }
                                }
                        ).collect(Collectors.toList());
            }

            public Collection<GameState> possibleStatesFrom() {
                int[] possibleStates = (currentTurn == Player.Mouse) ? graph[catNode] : graph[mouseNode];
                return Arrays.stream(possibleStates)
                        .boxed()
                        .filter(node -> node != 0)
                        .map(node -> {
                                    if (currentTurn == Player.Mouse) {
                                        return new GameState(mouseNode, node, currentTurn.opposite());
                                    } else {
                                        return new GameState(node, catNode, currentTurn.opposite());
                                    }
                                }
                        ).collect(Collectors.toList());
            }

            public void printGameState(Player winner) {
                System.out.println("Mouse Point: " + this.mouseNode
                        + ", Cat Point: " + this.catNode
                        + ", Turn: " + this.currentTurn
                        + " Winner: " + winner);
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
