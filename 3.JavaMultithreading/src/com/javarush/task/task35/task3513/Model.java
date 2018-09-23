package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    public Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public Stack<Tile[][]> previousStates = new Stack();
    public Stack<Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;
    public int maxTile;
    public int score;
    public Model() {
        resetGameTiles();
        maxTile = 0;
        score = 0;
    }
    private void saveState(Tile[][] tiles) {
//        Tile[][] tiles1 = Arrays.copyOf(tiles, tiles.length);
        Tile[][] tiles1 = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles1[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tiles1);
        previousScores.push(score);
        isSaveNeeded = false;
    }
    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }
    }

    public void randomMove() {
        int n = (int) ((Math.random() * 100) % 4);
        switch (n) {
            case 0: left();
            break;
            case 1: right();
            break;
            case 2: up();
            break;
            case 3: down();
        }
    }
    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1 , 0, move);
        rollback();
        return moveEfficiency;
    }

    public boolean hasBoardChanged() {
        Tile[][] peek = previousStates.peek();
        if (getTile(peek) != getTile(gameTiles)) return true;
        else return false;

    }
    public int getTile(Tile[][] tiles) {
        int tile = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tile += tiles[i][j].value;
            }
        }
        return tile;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int weight = Math.random() < 0.9 ? 2 : 4;
            emptyTiles.get((int) (emptyTiles.size() * Math.random())).value = weight;
        }
    }

    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean marker = false;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value == 0 && tiles[i + 1].value != 0) {
                    tiles[i].value = tiles[i + 1].value;
                    tiles[i + 1].value = 0;
                    marker = true;
                }
            }
        }
        return marker;
    }

    private boolean mergeTiles(Tile[] tiles) {
        int oldscore = score;
        boolean marker = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2 ;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                if (maxTile < tiles[i].value) maxTile = tiles[i].value;
            }
            if (score > oldscore) marker = true;
        }
        compressTiles(tiles);
        return marker;
    }
    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean ifNeed = false;
        for (int i = 0; i < gameTiles.length; i++) {
            boolean b = compressTiles(gameTiles[i]);
            boolean b1 = mergeTiles(gameTiles[i]);
            if (b || b1) ifNeed = true;
        }
        if (ifNeed)addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
        left();
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
    }
    public void down() {
        saveState(gameTiles);
        gameTiles = getRotateArr();
        left();
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
    }
    public void up() {
        saveState(gameTiles);
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
        gameTiles = getRotateArr();
        left();
        gameTiles = getRotateArr();
    }

    public Tile [][] getRotateArr() {
        Tile [][] retArr = new Tile[gameTiles[0].length][gameTiles.length];
        int retArrI = 0;
        int retArrJ = gameTiles.length - 1;
        for (Tile [] srI : gameTiles) {
            for (Tile srJ : srI)
                retArr[retArrI++][retArrJ] = srJ;
            retArrI = 0;
            retArrJ--;
        }
        return retArr;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int z = 0; z < FIELD_WIDTH; z++) {
            gameTiles = getRotateArr();
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles[i].length - 1; j++) {
                    if (gameTiles[i][j].value == gameTiles[i][j + 1].value) return true;
                    else if (gameTiles[i][j].value == 0) return true;
                    else if (gameTiles[i][3].value == 0) return true;
                }
            }
        }
        return false;
    }
//public boolean canMove() {
//    if (!getEmptyTiles().isEmpty())
//        return true;
//    for (int i = 0; i < gameTiles.length; i++) {
//        for (int j = 1; j < gameTiles.length; j++) {
//            if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
//                return true;
//        }
//    }
//    for (int j = 0; j < gameTiles.length; j++) {
//        for (int i = 1; i < gameTiles.length; i++) {
//            if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
//                return true;
//        }
//    }
//    return false;
//}
}
