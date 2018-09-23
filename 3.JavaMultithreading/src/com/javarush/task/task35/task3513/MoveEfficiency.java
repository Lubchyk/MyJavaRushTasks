package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency moveEfficiency) {
        if (this.numberOfEmptyTiles > moveEfficiency.numberOfEmptyTiles) return 1;
        else if (this.numberOfEmptyTiles < moveEfficiency.numberOfEmptyTiles) return -1;
        else if (this.numberOfEmptyTiles == moveEfficiency.numberOfEmptyTiles) {
            if (this.score > moveEfficiency.score) return 1;
            else if (this.score < moveEfficiency.score) return -1;
            else return 0;
        }
        else return 0;
    }
}
