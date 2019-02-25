/*********
 HW #3
 Due Date: 2/22/2019
 Name: Sam Schoenberg, Mason Dellutri
 *********/

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

//HW3 uses JPanels

public class HW3 extends JFrame {
    private JPanel mainPanel;           // panel to hold component
    private JPanel topPanel;
    private JPanel playerOneInfo;
    private JPanel playerTwoInfo;
    private JPanel ticTacPanel;
    private JPanel resetPanel;
    //private JOptionPane resetDoubleCheck;
    
    // private TitledBorder pOneTitle;
    // private TitledBorder pTwoTitle;
    private TitledBorder titleOne;
    private TitledBorder titleTwo;
    private JLabel nameLabelOne;
    private JLabel nameLabelTwo;
    private JLabel winsLabelOne;
    private JLabel lossesLabelOne;
    private JLabel winsLabelTwo;
    private JLabel lossesLabelTwo;
    private JLabel winsCountOne;
    private JLabel lossesCountOne;
    private JLabel winsCountTwo;
    private JLabel lossesCountTwo;
    private int winsOne = 0;
    private int winsTwo = 0;
    private int lossesOne = 0;
    private int lossesTwo = 0;
    private JTextField playerOneName;      // To hold user input
    private JTextField playerTwoName;      // To hold user input
    
    
    
    private JButton topLeft;        // top left spot
    private JButton topMiddle;      // top middle spot
    private JButton topRight;       // top right spot
    private JButton centerLeft;     // center left spot
    private JButton centerMiddle;   // center middle spot
    private JButton centerRight;    // center right spot
    private JButton bottomLeft;     // bottom left spot
    private JButton bottomMiddle;   // bottom middle spot
    private JButton bottomRight;    // bottom right spot
    private JButton newGame;        // to start new game
    private JButton reset;          // to reset game
    private JButton exit;           // to exit game
    
    public char topLeftClicked = ' ';
    public char topMiddleClicked = ' ';
    public char topRightClicked = ' ';
    public char centerLeftClicked = ' ';
    public char centerMiddleClicked = ' ';
    public char centerRightClicked = ' ';
    public char bottomLeftClicked = ' ';
    public char bottomMiddleClicked = ' ';
    public char bottomRightClicked = ' ';
    
    private JLabel statusLabel;
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    public int spotsLeft = 9;
    
    //constructor
    public HW3() {
        //set title
        setTitle("Tic Tac Toe");
        
        //set window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        //specify action for close button??
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Build the panel and add it to the frame.
        buildPanel();
        
        // Add the panel to the frame's content pane.
        add(mainPanel);
        
        setVisible(true);
        
    }
    
    private void buildPanel()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        
        // pOneTitle = BorderFactory.createTitledBorder("Player One (X)");
        // pTwoTitle = BorderFactory.createTitledBorder("Player Two (O)");
        
        titleOne = BorderFactory.createTitledBorder("Player One (X)");
        titleTwo = BorderFactory.createTitledBorder("Player Two (O)");
        
        playerOneInfo = new JPanel();
        playerOneInfo.setLayout(new GridLayout(3,2));
        playerOneInfo.setBorder(titleOne);
        playerTwoInfo = new JPanel();
        playerTwoInfo.setLayout(new GridLayout(3,2));
        playerTwoInfo.setBorder(titleTwo);
        ticTacPanel = new JPanel();
        ticTacPanel.setLayout(new GridLayout(3, 3));
        resetPanel = new JPanel();
        resetPanel.setLayout(new BorderLayout());
        
        
        nameLabelOne = new JLabel("Player Name:");
        winsLabelOne = new JLabel("Wins: ");
        winsCountOne = new JLabel(""+winsOne);
        lossesLabelOne = new JLabel("Losses: ");
        lossesCountOne = new JLabel(""+lossesOne);
        playerOneName = new JTextField(8);
        
        nameLabelTwo = new JLabel("Player Name:");
        winsLabelTwo = new JLabel("Wins: ");
        winsCountTwo = new JLabel(""+winsTwo);
        lossesLabelTwo = new JLabel("Losses: ");
        lossesCountTwo = new JLabel(""+lossesTwo);
        playerTwoName = new JTextField(8);
        
        //create the buttons
        topLeft = new JButton("");
        topMiddle = new JButton("");
        topRight = new JButton("");
        centerLeft = new JButton("");
        centerMiddle = new JButton("");
        centerRight = new JButton("");
        bottomLeft = new JButton("");
        bottomMiddle = new JButton("");
        bottomRight = new JButton("");
        newGame = new JButton("New Game");
        reset = new JButton("Reset");
        exit = new JButton("Exit");
        
        statusLabel = new JLabel("Enter player names then press New Game");
        
        //register event listeners for all 12 buttons
        topLeft.addActionListener(new topLeftListener());
        topMiddle.addActionListener(new topMiddleListener());
        topRight.addActionListener(new topRightListener());
        centerLeft.addActionListener(new centerLeftListener());
        centerMiddle.addActionListener(new centerMiddleListener());
        centerRight.addActionListener(new centerRightListener());
        bottomLeft.addActionListener(new bottomLeftListener());
        bottomMiddle.addActionListener(new bottomMiddleListener());
        bottomRight.addActionListener(new bottomRightListener());
        newGame.addActionListener(new newGameListener());
        reset.addActionListener(new resetListener());
        exit.addActionListener(new exitListener());
        
        // playerOneInfo.add(pOneNameLabel);
        // playerOneInfo.add(blankLabelOne);
        playerOneInfo.add(nameLabelOne);
        playerOneInfo.add(playerOneName);
        playerOneInfo.add(winsLabelOne);
        playerOneInfo.add(winsCountOne);
        playerOneInfo.add(lossesLabelOne);
        playerOneInfo.add(lossesCountOne);
        
        // playerTwoInfo.add(pTwoNameLabel);
        // playerTwoInfo.add(blankLabelTwo);
        playerTwoInfo.add(nameLabelTwo);
        playerTwoInfo.add(playerTwoName);
        playerTwoInfo.add(winsLabelTwo);
        playerTwoInfo.add(winsCountTwo);
        playerTwoInfo.add(lossesLabelTwo);
        playerTwoInfo.add(lossesCountTwo);
        
        
        ticTacPanel.add(topLeft);
        ticTacPanel.add(topMiddle);
        ticTacPanel.add(topRight);
        ticTacPanel.add(centerLeft);
        ticTacPanel.add(centerMiddle);
        ticTacPanel.add(centerRight);
        ticTacPanel.add(bottomLeft);
        ticTacPanel.add(bottomMiddle);
        ticTacPanel.add(bottomRight);
        
        resetPanel.add((newGame), BorderLayout.WEST);
        resetPanel.add((reset), BorderLayout.CENTER);
        resetPanel.add((exit), BorderLayout.EAST);
        resetPanel.add((statusLabel), BorderLayout.SOUTH);
        
        topPanel.add(playerOneInfo);
        topPanel.add(playerTwoInfo);
        
        mainPanel.add((topPanel), BorderLayout.NORTH);
        mainPanel.add((ticTacPanel), BorderLayout.CENTER);
        mainPanel.add((resetPanel), BorderLayout.SOUTH);
        
    }
    
    private class topLeftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(topLeftClicked == 'x' || topLeftClicked == 'o'))) {
                if(spotsLeft%2 == 1)
                {
                    topLeft.setText("X");
                    topLeftClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    topLeft.setText("O");
                    topLeftClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class topMiddleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(topMiddleClicked == 'x' || topMiddleClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    topMiddle.setText("X");
                    topMiddleClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    topMiddle.setText("O");
                    topMiddleClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class topRightListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(topRightClicked == 'x' || topRightClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    topRight.setText("X");
                    topRightClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    topRight.setText("O");
                    topRightClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class centerLeftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(centerLeftClicked == 'x' || centerLeftClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    centerLeft.setText("X");
                    centerLeftClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    centerLeft.setText("O");
                    centerLeftClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class centerMiddleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(centerMiddleClicked == 'x' || centerMiddleClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    centerMiddle.setText("X");
                    centerMiddleClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    centerMiddle.setText("O");
                    centerMiddleClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class centerRightListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(centerRightClicked == 'x' || centerRightClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    centerRight.setText("X");
                    centerRightClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    centerRight.setText("O");
                    centerRightClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class bottomLeftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(bottomLeftClicked == 'x' || bottomLeftClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    bottomLeft.setText("X");
                    bottomLeftClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    bottomLeft.setText("O");
                    bottomLeftClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class bottomMiddleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(bottomMiddleClicked == 'x' || bottomMiddleClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    bottomMiddle.setText("X");
                    bottomMiddleClicked = 'o';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    bottomMiddle.setText("O");
                    bottomMiddleClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class bottomRightListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((spotsLeft > 0) && (!(bottomRightClicked == 'x' || bottomRightClicked == 'o'))) {
                if(spotsLeft % 2 == 1)
                {
                    bottomRight.setText("X");
                    bottomRightClicked = 'x';
                    statusLabel.setText(playerTwoName.getText() + "'s turn");
                }
                else
                {
                    bottomRight.setText("O");
                    bottomRightClicked = 'o';
                    statusLabel.setText(playerOneName.getText() + "'s turn");
                }
                spotsLeft--;
            }
            winChecker();
        }
    }
    
    private class newGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            playerOneName.setEditable(false);
            playerTwoName.setEditable(false);
            statusLabel.setText(playerOneName.getText() + "'s turn");
        }
    }
    
    private class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int resetDoubleCheck = JOptionPane.YES_NO_OPTION;
           /* resetDoubleCheck = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "WARNING", resetDoubleCheck);
            */
            if(JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            topLeft.setText("");
            topLeftClicked = ' ';
            topMiddle.setText("");
            topMiddleClicked = ' ';
            topRight.setText("");
            topRightClicked = ' ';
            centerLeft.setText("");
            centerLeftClicked = ' ';
            centerMiddle.setText("");
            centerMiddleClicked = ' ';
            centerRight.setText("");
            centerRightClicked = ' ';
            bottomLeft.setText("");
            bottomLeftClicked = ' ';
            bottomMiddle.setText("");
            bottomMiddleClicked = ' ';
            bottomRight.setText("");
            bottomRightClicked = ' ';
            spotsLeft = 9;
            playerOneName.setEditable(true);
            playerTwoName.setEditable(true);
            playerOneName.setText("Player One");
            playerTwoName.setText("Player Two");
            winsOne = 0;
            lossesOne = 0;
            winsTwo = 0;
            lossesTwo = 0;
            winsCountOne.setText(""+winsOne);
            lossesCountOne.setText(""+lossesOne);
            winsCountTwo.setText(""+winsTwo);
            lossesCountTwo.setText(""+lossesTwo);
            statusLabel.setText("Enter player names then press New Game");
            }
            // else {
            //     JOptionPane.showConfirmDialog(parentComponent, message)
            // }
            
        }
    }
    private class exitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new HW3();
    }
    
    public boolean winChecker(){
        if(rowWinChecker() || columnWinChecker() || diagonalWinChecker()) {
            winStats();
            return true;
            
        }
        return false;
    }
    
     public void winStats() {
         if(rowWinChecker() || columnWinChecker() || diagonalWinChecker()) {
             if(pickWinner() == 'x') {
                 winsOne++;
                 lossesTwo++;
                 winsCountOne.setText(""+winsOne);
                 lossesCountTwo.setText(""+lossesTwo);
             }
             else if(pickWinner() == 'o') {
                 winsTwo++;
                 lossesOne++;
                 winsCountTwo.setText(""+winsTwo);
                 lossesCountOne.setText(""+lossesOne);
             }
             topLeft.setText("");
            topLeftClicked = ' ';
            topMiddle.setText("");
            topMiddleClicked = ' ';
            topRight.setText("");
            topRightClicked = ' ';
            centerLeft.setText("");
            centerLeftClicked = ' ';
            centerMiddle.setText("");
            centerMiddleClicked = ' ';
            centerRight.setText("");
            centerRightClicked = ' ';
            bottomLeft.setText("");
            bottomLeftClicked = ' ';
            bottomMiddle.setText("");
            bottomMiddleClicked = ' ';
            bottomRight.setText("");
            bottomRightClicked = ' ';
            spotsLeft = 9;
         }
     }
     
     private boolean rowWinChecker() {
         //checks if values match in any row
         if(topLeftClicked == topMiddleClicked && topMiddleClicked == topRightClicked && (topRightClicked == 'x' || topRightClicked =='o')) {
             return true;
         }
         else if(centerLeftClicked == centerMiddleClicked && centerMiddleClicked == centerRightClicked && (centerRightClicked == 'x' || centerRightClicked =='o')) {
             return true;
         }
         else if(bottomLeftClicked == bottomMiddleClicked && bottomMiddleClicked == bottomRightClicked && (bottomRightClicked == 'x' || bottomRightClicked =='o')) {
             return true;
         }
         else
             return false;
     }
    
    private boolean columnWinChecker() {
        //checks if values match in any column
        if(topLeftClicked == centerLeftClicked && centerLeftClicked == bottomLeftClicked  && (bottomLeftClicked == 'x' || bottomLeftClicked =='o')) {
            return true;
        }
        else if(topMiddleClicked == centerMiddleClicked && centerMiddleClicked == bottomMiddleClicked && (bottomMiddleClicked == 'x' || bottomMiddleClicked =='o')) {
            return true;
        }
        else if(topRightClicked == centerRightClicked && centerRightClicked == bottomRightClicked && (bottomRightClicked == 'x' || bottomRightClicked =='o')) {
            return true;
        }
        else
            return false;
    }
    
    private boolean diagonalWinChecker() {
        //checks if values match in either diagonal
        if(topLeftClicked == centerMiddleClicked && centerMiddleClicked == bottomRightClicked && (bottomRightClicked == 'x' || bottomRightClicked =='o')) {
            return true;
        }
        else if(topRightClicked == centerMiddleClicked && centerMiddleClicked == bottomLeftClicked  && (bottomLeftClicked == 'x' || bottomLeftClicked =='o')) {
            return true;
        }
        else
            return false;
    }
    
    private char pickWinner() {
        //called when one of the wincheckers is true. returns the character 'x' if x is the winner, and 'o' if o is the winner
        if(topLeftClicked == topMiddleClicked && topMiddleClicked == topRightClicked) {
            if(topLeftClicked == 'x')
                return 'x';
            if(topLeftClicked == 'o')
                return 'o';
        }
        else if(centerLeftClicked == centerMiddleClicked && centerMiddleClicked == centerRightClicked) {
            if(centerLeftClicked == 'x')
                return 'x';
            if(centerLeftClicked == 'o')
                return 'o';
        }
        else if(bottomLeftClicked == bottomMiddleClicked && bottomMiddleClicked == bottomRightClicked) {
            if(bottomLeftClicked == 'x')
                return 'x';
            if(bottomLeftClicked == 'o')
                return 'o';
        }
        else if(topLeftClicked == centerLeftClicked && centerLeftClicked == bottomLeftClicked) {
            if(topLeftClicked == 'x')
                return 'x';
            if(topLeftClicked == 'o')
                return 'o';
        }
        else if(topMiddleClicked == centerMiddleClicked && centerMiddleClicked == bottomMiddleClicked) {
            if(topMiddleClicked == 'x')
                return 'x';
            if(topMiddleClicked == 'o')
                return 'o';
        }
        else if(topRightClicked == centerRightClicked && centerRightClicked == bottomRightClicked) {
            if(topRightClicked == 'x')
                return 'x';
            if(topRightClicked == 'o')
                return 'o';
        }
        else if(topLeftClicked == centerMiddleClicked && centerMiddleClicked == bottomRightClicked) {
            if(topLeftClicked == 'x')
                return 'x';
            if(topLeftClicked == 'o')
                return 'o';
        }
        else if(topRightClicked == centerMiddleClicked && centerMiddleClicked == bottomLeftClicked) {
            if(topRightClicked == 'x')
                return 'x';
            if(topRightClicked == 'o')
                return 'o';
        }
        return 'a';
    }
    
}
