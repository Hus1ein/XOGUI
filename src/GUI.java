import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {

    private List<JButton> buttonList;
    private GameLogic gameLogic;

    public GUI() {
        gameLogic = new GameLogic();
    }

    public void runGUI() {

        buttonList = new ArrayList<>();

        JFrame jFrame = new JFrame("XO");
        jFrame.setSize(1000, 1000);

        JPanel jPanelCenter = new JPanel();

        jPanelCenter.setBackground(Color.RED);

        jPanelCenter.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton((i + 1)+ "");
            buttonList.add(button);
            button.addActionListener(new ButtonClickListener());
            jPanelCenter.add(button);
        }

        jFrame.add(jPanelCenter);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            gameLogic.increaseClickCounter();
            int currentPlayer = gameLogic.getCurrentPlayer();
            int position = Integer.parseInt(e.getActionCommand()) - 1;

            if (currentPlayer == 0) {
                buttonList.get(position).setText("X");
                buttonList.get(position).setBackground(Color.RED);
            }else if (currentPlayer == 1) {
                buttonList.get(position).setText("O");
                buttonList.get(position).setBackground(Color.GREEN);
            }

            gameLogic.addSelectedBtns(position + 1);
            buttonList.get(position).setFont(new Font("serif", Font.PLAIN, 60));
            buttonList.get(position).setEnabled(false);

            if (gameLogic.isGameOver()) {
                JOptionPane.showMessageDialog(null, "Game Over, " + currentPlayer + " is winner");
                for (int i = 0; i < 9 ;i++) {
                    if (buttonList.get(i).isEnabled()){
                        buttonList.get(i).setEnabled(false);
                    }
                }
            }else {
                if (gameLogic.getClickCounter() >= 9){
                    for (int i = 0; i < 9 ;i++) {
                        if (buttonList.get(i).isEnabled()){
                            buttonList.get(i).setEnabled(false);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Game Over, No winner");
                }else {
                    if (currentPlayer == 0){
                        gameLogic.setCurrentPlayer(1);
                    }else {
                        gameLogic.setCurrentPlayer(0);
                    }
                }

            }

        }
    }
}
