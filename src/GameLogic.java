import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    private int currentPlayer;
    private int[][] forWin = {{1,2,3}, {4,5,6}, {7,8,9}, {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {3,5,7}};
    private List<Integer> selectedBtnsPlayer0;
    private List<Integer> selectedBtnsPlayer1;
    private int clickCounter;

    public GameLogic() {
        currentPlayer = 0;
        selectedBtnsPlayer0 = new ArrayList<>();
        selectedBtnsPlayer1 = new ArrayList<>();
        clickCounter = 0;
    }

    public boolean isGameOver() {
        int counter = 0;
        List<Integer> selectedBtns;

        if (currentPlayer == 0) {
            selectedBtns = selectedBtnsPlayer0;
        }else {
            selectedBtns = selectedBtnsPlayer1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                if (selectedBtns.contains(forWin[i][j])) {
                    counter++;
                }else{
                    break;
                }
            }
            if (counter == 3){
                return true;
            }else {
                counter = 0;
            }
        }
        return false;
    }

    public void addSelectedBtns(int btnPosition) {
        if (currentPlayer == 0) {
            selectedBtnsPlayer0.add(btnPosition);
        } else {
            selectedBtnsPlayer1.add(btnPosition);
        }
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void increaseClickCounter() {
        this.clickCounter++;
    }

    public int getClickCounter() {
        return clickCounter;
    }


}
