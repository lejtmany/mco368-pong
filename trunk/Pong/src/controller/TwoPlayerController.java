package controller;

import java.awt.event.KeyEvent;
import model.Paddle;
import model.TwoPlayerModel;
import view.PongGUI;

public class TwoPlayerController extends BoardController{
    
    private TwoPlayerModel board;

    public TwoPlayerController(TwoPlayerModel board, PongGUI gui) {
        super(board, gui);
        this.board = board;
        addPaddleKeyListeners();
    }

    @Override
    protected void addPaddleKeyListeners() {
        Paddle paddle1 = super.board.getPaddles().get(0);
        Paddle paddle2 = super.board.getPaddles().get(1);
        super.gui.getPongPanel().addKeyListener(generatePaddleKeyListeners(paddle2, KeyEvent.VK_UP, KeyEvent.VK_DOWN) );
        super.gui.getPongPanel().addKeyListener(generatePaddleKeyListeners(paddle1, KeyEvent.VK_W, KeyEvent.VK_S) );
    }

    @Override
    protected void updateScoreLabel() {
       gui.getScoreLabel().setText(
               String.format("%s%-30d %s%d", "Player 1: ", board.getLeftPlayerScore(),"Player 2: " ,board.getRightPlayerScore()));
    }

    @Override
    protected void gameOver() {
        gui.displayGameOver("");
    }
    
    
}
