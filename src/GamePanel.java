import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    
    JPanel resetAndTurnPanel;
    JPanel newButtonsPanel;
    JPanel scorePanel;
    JLabel turnOX;
    JLabel scoreO;
    JLabel scoreX;
    JButton[] buttonOX;
    JButton resetButton;

    Random random;
    boolean player1Turn;
    int pointO, pointX;

    GamePanel(){
        setScorePanel();
        setResetAndTurnPanel();
        gameStart();
    }

    public void setResetAndTurnPanel(){
        resetAndTurnPanel = new JPanel();
        resetAndTurnPanel.setBackground(Color.BLACK);
        turnOX = new JLabel();
        turnOX.setFont(new Font("Consolas",Font.BOLD, 70));
        resetAndTurnPanel.add(turnOX);
        resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.setForeground(Color.BLUE);
        resetButton.setFont(new Font("Consolas",Font.BOLD, 70));
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setContentAreaFilled(false);
        resetAndTurnPanel.add(resetButton);
        this.add(resetAndTurnPanel, BorderLayout.NORTH);
    }

    public void newButtonsPanel(){
        newButtonsPanel = new JPanel();
        buttonOX = new JButton[9];
        newButtonsPanel.setLayout(new GridLayout(3,3));
        for(int i=0; i<9; i++){
            buttonOX[i] = new JButton();
            buttonOX[i].setFont(new Font("Consolas",Font.BOLD, 100));
            buttonOX[i].setFocusable(false);
            buttonOX[i].addActionListener(this);
            newButtonsPanel.add(buttonOX[i]);
        }
        this.add(newButtonsPanel);
    }

    public void setScorePanel(){
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLACK);
        scoreO = new JLabel();
        scoreO.setText("O SCORE 00 ");
        scoreO.setFont(new Font("Consolas",Font.BOLD, 60));
        scoreO.setForeground(Color.CYAN);
        scoreX = new JLabel();
        scoreX.setText("X SCORE 00");
        scoreX.setFont(new Font("Consolas",Font.BOLD, 60));
        scoreX.setForeground(Color.MAGENTA);
        scorePanel.add(scoreO, BorderLayout.WEST);
        scorePanel.add(scoreX, BorderLayout.EAST);
        this.setLayout(new BorderLayout());
        this.add(scorePanel, BorderLayout.SOUTH);
    }

    public void gameStart(){
        newButtonsPanel();
        random = new Random();
        disablebuttons();
        if(random.nextInt(2)==0)
            turnO();
        else
            turnX();
        enablebuttons();
    }

    public void disablebuttons(){
        for(int i=0 ; i<9 ; i++)
            buttonOX[i].setEnabled(false);
    }

    public void enablebuttons(){
        for(int i=0 ; i<9 ; i++)
            buttonOX[i].setEnabled(true);
    }

    public void turnO(){
        player1Turn = true;
        turnOX.setForeground(Color.CYAN);
        turnOX.setText("TURN O ");
    }

    public void turnX(){
        player1Turn = false;
        turnOX.setForeground(Color.MAGENTA);
        turnOX.setText("TURN X ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        random = new Random();
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttonOX[i]) {
				if(player1Turn){
                    if(buttonOX[i].getText()==""){
                        buttonOX[i].setForeground(Color.CYAN);
                        buttonOX[i].setText("O");
                        turnX();
                        check();
                    }
				}
				else {
					if(buttonOX[i].getText()==""){
                        buttonOX[i].setForeground(Color.MAGENTA);
                        buttonOX[i].setText("X");
                        turnO();
                        check();
					}
				}
			}			
		}
        if(e.getSource()==resetButton){
            this.remove(newButtonsPanel);
            gameStart();
        }
	}

    public void check(){
        if((buttonOX[0].getText()=="X") &&
            (buttonOX[1].getText()=="X") &&
                (buttonOX[2].getText()=="X")){
                    xWins(0,1,2);}
        if((buttonOX[3].getText()=="X") &&
            (buttonOX[4].getText()=="X") &&
                (buttonOX[5].getText()=="X")){
                    xWins(3,4,5);}
        if((buttonOX[6].getText()=="X") &&
            (buttonOX[7].getText()=="X") &&
                (buttonOX[8].getText()=="X")){
                    xWins(6,7,8);}
        if((buttonOX[0].getText()=="X") &&
            (buttonOX[3].getText()=="X") &&
                (buttonOX[6].getText()=="X")){
                    xWins(0,3,6);}
        if((buttonOX[1].getText()=="X") &&
            (buttonOX[4].getText()=="X") &&
                (buttonOX[7].getText()=="X")){
                    xWins(1,4,7);}
        if((buttonOX[2].getText()=="X") &&
            (buttonOX[5].getText()=="X") &&
                (buttonOX[8].getText()=="X")){
                    xWins(2,5,8);}
        if((buttonOX[2].getText()=="X") &&
            (buttonOX[4].getText()=="X") &&
                (buttonOX[6].getText()=="X")){
                    xWins(2,4,6);}
        if((buttonOX[0].getText()=="X") &&
            (buttonOX[4].getText()=="X") &&
                (buttonOX[8].getText()=="X")){
                    xWins(0,4,8);}

        if((buttonOX[0].getText()=="O") &&
            (buttonOX[1].getText()=="O") &&
                (buttonOX[2].getText()=="O")){
                    oWins(0,1,2);}
        if((buttonOX[3].getText()=="O") &&
            (buttonOX[4].getText()=="O") &&
                (buttonOX[5].getText()=="O")){
                    oWins(3,4,5);}
        if((buttonOX[6].getText()=="O") &&
            (buttonOX[7].getText()=="O") &&
                (buttonOX[8].getText()=="O")){
                    oWins(6,7,8);}
        if((buttonOX[0].getText()=="O") &&
            (buttonOX[3].getText()=="O") &&
                (buttonOX[6].getText()=="O")){
                    oWins(0,3,6);}
        if((buttonOX[1].getText()=="O") &&
            (buttonOX[4].getText()=="O") &&
                (buttonOX[7].getText()=="O")){
                    oWins(1,4,7);}
        if((buttonOX[2].getText()=="O") &&
            (buttonOX[5].getText()=="O") &&
                (buttonOX[8].getText()=="O")){
                    oWins(2,5,8);}
        if((buttonOX[2].getText()=="O") &&
            (buttonOX[4].getText()=="O") &&
                (buttonOX[6].getText()=="O")){
                    oWins(2,4,6);}
        if((buttonOX[0].getText()=="O") &&
            (buttonOX[4].getText()=="O") &&
                (buttonOX[8].getText()=="O")){
                    oWins(0,4,8);}

        for(int i=0; i<9; i++){
            if(buttonOX[i].getText().isBlank())
                break;
            if(i==8)
                oxDraw();      
        }

    }

    public void oWins(int a, int b, int c){
        buttonOX[a].setBackground(Color.GREEN);
        buttonOX[b].setBackground(Color.GREEN);
        buttonOX[c].setBackground(Color.GREEN);
        turnOX.setForeground(Color.CYAN);
        turnOX.setText("O WINS!");
        disablebuttons();
        scoreO();
    }

    public void xWins(int a, int b, int c){
        buttonOX[a].setBackground(Color.GREEN);
        buttonOX[b].setBackground(Color.GREEN);
        buttonOX[c].setBackground(Color.GREEN);
        turnOX.setForeground(Color.MAGENTA);
        turnOX.setText("X WINS!");
        disablebuttons();
        scoreX();
    }

    public void oxDraw(){
        for(int i=0; i<9; i++){
            buttonOX[i].setBackground(Color.RED);
            turnOX.setForeground(Color.BLUE);
            turnOX.setText("DRAW!");
            disablebuttons();
        }
    }

    public void scoreO(){
        pointO++;
        if(pointO<10)
            scoreO.setText("O SCORE 0"+pointO+" ");
        else
            scoreO.setText("O SCORE "+pointO);
    }
    
    public void scoreX(){
        pointX++;
        if(pointX<10)
            scoreX.setText("X SCORE 0"+pointX);
        else
            scoreX.setText("X SCORE "+pointX);
    }
    
}
