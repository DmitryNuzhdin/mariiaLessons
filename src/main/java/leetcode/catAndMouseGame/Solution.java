package leetcode.catAndMouseGame;

import java.util.*;

class Solution {
    public HashMap<GameState, Integer> stateDictionary = new HashMap<>();
    public Deque<GameState> gameStateToAnalise = new LinkedList<>();

    public int catMouseGame(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            setInitialGameState(i, i, true, 2);
            setInitialGameState(0, i, false, 1);
            if (graph[i].length == 1 && graph[i][0] != 0) {
                setInitialGameState(graph[i][0], graph[i][0], false, 2);
            }
        }
        while (!gameStateToAnalise.isEmpty()) {
            GameState currentGameState = gameStateToAnalise.remove();
            currentGameState.generateRelatedGameState(graph);
        }
        GameState startOfGame = new GameState(1, 2, true);
        Integer exodus = stateDictionary.get(startOfGame);
        return (exodus == null) ? 0 : exodus;
    }

    public void setInitialGameState(int mouseState, int catState, boolean mouseTurn, int winner) {
        GameState gameState = new GameState(mouseState, catState, mouseTurn);
        stateDictionary.put(gameState, winner);
        gameStateToAnalise.add(gameState);
    }

    public class GameState {
        final int mouseNode;
        final int catNode;
        final boolean mouseTurn;

        public GameState(int mouseNode, int catNode, boolean mouseTurn) {
            this.mouseNode = mouseNode;
            this.catNode = catNode;
            this.mouseTurn = mouseTurn;
        }

        public void addGameStateIfNeed(int winner) {
            Integer GameExodus = stateDictionary.get(this);
            if (GameExodus == null) {
                gameStateToAnalise.add(this);
                stateDictionary.put(this, winner);
            } else if (GameExodus == 0 && winner!= 0) {
                stateDictionary.put(this, winner);
                gameStateToAnalise.add(this);
            }
        }

        public void printGameState (int winner) {
            System.out.println("Mouse Point: " + this.mouseNode
                    + ", Cat Point: " + this.catNode
                    + ", MouseTurn: " + this.mouseTurn
                    + " Winner: " + winner);
        }

        public int analiseRelatedGameStates(int[] availableNodes) {
            Integer winner = stateDictionary.get(this);
            if (winner == null || winner == 0) {
                if (this.mouseTurn) {
                    winner = 2;
                    for (int availableNode : availableNodes) {
                        if (availableNode != 0 && availableNode != this.catNode) {
                            GameState toCheckGameState = new GameState(availableNode, this.catNode, false);
                            Integer result = stateDictionary.get(toCheckGameState);
                            if (result == null || result == 0) {
                                winner = 0;
                            } else if (result == 1) {
                                return result;
                            }
                        }
                    }
                } else {
                    winner = 1;
                    for (int availableNode : availableNodes) {
                        if (availableNode != 0 && availableNode != this.mouseNode) {
                            GameState toCheckGameState = new GameState(this.mouseNode, availableNode, true);
                            Integer result = stateDictionary.get(toCheckGameState);
                            if (result == null || result == 0) {
                                winner = 0;
                            } else if (result == 2) {
                                return result;
                            }
                        }
                    }
                }
            }
            return winner;
        }

        public void generateRelatedGameState (int[][] graph) {
            int mousePoint = this.mouseNode;
            int catPoint = this.catNode;
            boolean mouseTurn = this.mouseTurn;
            int winner = stateDictionary.get(this);
            if (mouseTurn) {
                for (int k = 0; k < graph[catPoint].length; k++) {
                    if (graph[catPoint][k] != 0 && graph[catPoint][k] != mousePoint) {
                        GameState toAddGameState = new GameState(mousePoint, graph[catPoint][k], false);
                        int currentWinnerForState = (winner != 2) ? toAddGameState.analiseRelatedGameStates(graph[toAddGameState.catNode]) : winner ;
                        toAddGameState.addGameStateIfNeed(currentWinnerForState);
                    }
                }
            } else {
                for (int i = 0; i < graph[mousePoint].length; i++) {
                    if (graph[mousePoint][i] != catPoint && graph[mousePoint][i] != 0) {
                        GameState toAddGameState = new GameState(graph[mousePoint][i],catPoint,true);
                        int currentWinnerForState = (winner != 1) ? toAddGameState.analiseRelatedGameStates(graph[toAddGameState.mouseNode]) : winner ;
                        toAddGameState.addGameStateIfNeed(currentWinnerForState);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameState gameState = (GameState) o;
            return mouseNode == gameState.mouseNode &&
                    catNode == gameState.catNode &&
                    mouseTurn == gameState.mouseTurn;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mouseNode, catNode, mouseTurn);
        }

    }
}
