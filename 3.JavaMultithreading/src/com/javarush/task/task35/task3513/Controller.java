package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
    public int getScore() {
        return model.score;
    }

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }
    public void resetGame() {
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ESCAPE) resetGame();
        else {
            if (!model.canMove()) view.isGameLost = true;
            if (!view.isGameLost && !view.isGameWon) {
                if (keyCode == KeyEvent.VK_LEFT) model.left();
                else if (keyCode == KeyEvent.VK_RIGHT) model.right();
                else if (keyCode == KeyEvent.VK_UP) model.up();
                else if (keyCode == KeyEvent.VK_DOWN) model.down();
                else if (keyCode == KeyEvent.VK_Z) model.rollback();
                else if (keyCode == KeyEvent.VK_R) model.randomMove();
                else if (keyCode == KeyEvent.VK_A) model.autoMove();
            }
            if (model.maxTile == WINNING_TILE) view.isGameWon = true;
        }
        view.repaint();
    }

    public View getView() {
        return view;
    }
}
