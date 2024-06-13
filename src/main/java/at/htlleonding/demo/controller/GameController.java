package at.htlleonding.demo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class GameController {
    public Label rollLabel;
    public Button btnRoll;
    public ListView lvSoldRolls;
    public int currentRoll = 0;
    public int currentPoints = 0;
    public Label pointsLabel;
    public Button btnOdd;
    public Button btnEven;
    public Button btnTriple;
    public Button btnQuad;
    public Button btnYahtzee;

    private int[] rolls = new int[5];

    private String getRollSymbol(int roll) {
        switch (roll) {
            case 1:
                return "⚀";
            case 2:
                return "⚁";
            case 3:
                return "⚂";
            case 4:
                return "⚃";
            case 5:
                return "⚄";
            case 6:
                return "⚅";
            default:
                return "-";
        }
    }

    private String getSellMessage(int type, boolean success) {
        if (success) {
            switch (type) {
                case 1: return String.format("SUCCESS:     %d-%d-%d-%d-%d (%d) sold as Odd! (+%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 2);
                case 2: return String.format("SUCCESS:     %d-%d-%d-%d-%d (%d) sold as Even! (+%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 2);
                case 3: return String.format("SUCCESS:     %d-%d-%d-%d-%d (%d) sold as Triplet! (+%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 5);
                case 4: return String.format("SUCCESS:     %d-%d-%d-%d-%d (%d) sold as Quadruplet! (+%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 8);
                case 5: return String.format("SUCCESS:     %d-%d-%d-%d-%d (%d) sold as Yahtzee! (+%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 25);
            }
        } else {
            switch (type) {
                case 1: return String.format("FAILURE:      %d-%d-%d-%d-%d (%d) failed to sell as Odd! (-%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 1);
                case 2: return String.format("FAILURE:      %d-%d-%d-%d-%d (%d) failed to sell as Even! (-%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 1);
                case 3: return String.format("FAILURE:      %d-%d-%d-%d-%d (%d) failed to sell as Triplet! (-%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 3);
                case 4: return String.format("FAILURE:      %d-%d-%d-%d-%d (%d) failed to sell as Quadruplet! (-%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 6);
                case 5: return String.format("FAILURE:      %d-%d-%d-%d-%d (%d) failed to sell as Yahtzee! (-%d)", rolls[0], rolls[1], rolls[2], rolls[3], rolls[4], currentRoll, 15);

            }
        }

        return "";
    }

    private void disableButtons(boolean disable) {
        btnOdd.setDisable(disable);
        btnEven.setDisable(disable);
        btnTriple.setDisable(disable);
        btnQuad.setDisable(disable);
        btnYahtzee.setDisable(disable);
    }

    public void onBtnRollAction(ActionEvent actionEvent) {
        int roll1 = (int) (Math.random() * 6) + 1;
        int roll2 = (int) (Math.random() * 6) + 1;
        int roll3 = (int) (Math.random() * 6) + 1;
        int roll4 = (int) (Math.random() * 6) + 1;
        int roll5 = (int) (Math.random() * 6) + 1;

        currentRoll = roll1 + roll2 + roll3 + roll4 + roll5;
        rolls = new int[]{roll1, roll2, roll3, roll4, roll5};

        disableButtons(false);

        rollLabel.setText(String.format("%s   %s   %s   %s   %s", getRollSymbol(roll1), getRollSymbol(roll2), getRollSymbol(roll3), getRollSymbol(roll4), getRollSymbol(roll5)));
    }

    public void btnSellOddOnAction(ActionEvent actionEvent) {
        boolean success = currentRoll % 2 != 0;

        if (success) {
            currentPoints += 2;
        } else {
            currentPoints -= 1;
        }

        pointsLabel.setText(String.format("Current Points: %d", currentPoints));

        rollLabel.setText("-   -   -   -   -");
        disableButtons(true);

        // the message added should be colored red or green depending on the success
        lvSoldRolls.getItems().add(0, getSellMessage(1, success));
        btnRoll.requestFocus();

    }

    public void btnSellEvenOnAction(ActionEvent actionEvent) {
        boolean success = currentRoll % 2 == 0;

        if (success) {
            currentPoints += 2;
        } else {
            currentPoints -= 1;
        }

        pointsLabel.setText(String.format("Current Points: %d", currentPoints));

        rollLabel.setText("-   -   -   -   -");
        disableButtons(true);

        lvSoldRolls.getItems().add(0, getSellMessage(2, success));
        btnRoll.requestFocus();
    }


    public void btnSellTripleOnAction(ActionEvent actionEvent) {
        boolean threeEqual = false;

        for (int i = 0; i < rolls.length - 2; i++) {
            for (int j = i + 1; j < rolls.length - 1; j++) {
                for (int k = j + 1; k < rolls.length; k++) {
                    if (rolls[i] == rolls[j] && rolls[j] == rolls[k]) {
                        threeEqual = true;
                    }
                }
            }
        }

        if (threeEqual) {
            currentPoints += 5;
        } else {
            currentPoints -= 3;
        }

        pointsLabel.setText(String.format("Current Points: %d", currentPoints));

        rollLabel.setText("-   -   -   -   -");
        disableButtons(true);

        lvSoldRolls.getItems().add(0, getSellMessage(3, threeEqual));
        btnRoll.requestFocus();
    }

    public void btnSellQuadOnAction(ActionEvent actionEvent) {
        boolean fourEqual = false;

        for (int i = 0; i < rolls.length - 3; i++) {
            for (int j = i + 1; j < rolls.length - 2; j++) {
                for (int k = j + 1; k < rolls.length - 1; k++) {
                    for (int l = k + 1; l < rolls.length; l++) {
                        if (rolls[i] == rolls[j] && rolls[j] == rolls[k] && rolls[k] == rolls[l]) {
                            fourEqual = true;
                        }
                    }
                }
            }
        }

        if (fourEqual) {
            currentPoints += 8;
        } else {
            currentPoints -= 6;
        }

        pointsLabel.setText(String.format("Current Points: %d", currentPoints));

        rollLabel.setText("-   -   -   -   -");
        disableButtons(true);

        lvSoldRolls.getItems().add(0, getSellMessage(4, fourEqual));
        btnRoll.requestFocus();
    }

    public void btnSellYahtzeeOnAction(ActionEvent actionEvent) {
        boolean success = false;

        if(rolls[0] == rolls[1] && rolls[1] == rolls[2] && rolls[2] == rolls[3] && rolls[3] == rolls[4]) {
            currentPoints += 25;
            success = true;
        } else {
            currentPoints -= 15;
        }

        pointsLabel.setText(String.format("Current Points: %d", currentPoints));

        rollLabel.setText("-   -   -   -   -");
        disableButtons(true);

        lvSoldRolls.getItems().add(0, getSellMessage(5, success));
        btnRoll.requestFocus();
    }
}