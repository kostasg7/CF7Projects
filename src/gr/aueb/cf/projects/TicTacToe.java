package gr.aueb.cf.projects;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] arr = new String[3][3];
        int playerTurn = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = "-";
            }
        }
        printMenu();
        while (true) {
            printArray(arr);
            int choice;
            while (true) {
                System.out.println("Please enter your choice (1-9):");
                choice = in.nextInt();
                if (choice >= 1 && choice <= 9) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            if (playerTurn == 1) {
                if (isPlaceTaken(arr, choice)){
                    System.out.println("Place taken, try again\n");
                }
                else {
                    makeMove(arr, choice, firstPlayer());
                    playerTurn = 2;
                }
                if (win(arr, firstPlayer())) {
                    printArray(arr);
                    System.out.println("Player 1 has won the game!!!");
                    return;
                } else if (draw(arr)) {
                    printArray(arr);
                    System.out.println("Draw!");
                    return;
                }

            } else {
                if (isPlaceTaken(arr, choice)){
                    System.out.println("Place taken, try again\n");
                }
                else {
                    makeMove(arr, choice, secondPlayer());
                    playerTurn = 1;
                }
                if (win(arr, secondPlayer())) {
                    printArray(arr);
                    System.out.println("Player 2 has won the game!!!");
                    return;
                } else if (draw(arr)) {
                    printArray(arr);
                    System.out.println("Draw!");
                    return;
                }
            }
        }
    }

    public static String firstPlayer() {
        return "X";
    }

    public static String secondPlayer() {
        return "O";
    }

    public static void printArray(String[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isPlaceTaken(String[][] arr, int choice) {
        switch (choice) {
            case 1 -> {
                return !arr[2][0].equals("-");
            }
            case 2 -> {
                return !arr[2][1].equals("-");
            }
            case 3 -> {
                return !arr[2][2].equals("-");
            }
            case 4 -> {
                return !arr[1][0].equals("-");
            }
            case 5 -> {
                return !arr[1][1].equals("-");
            }
            case 6 -> {
                return !arr[1][2].equals("-");
            }
            case 7 -> {
                return !arr[0][0].equals("-");
            }
            case 8 -> {
                return !arr[0][1].equals("-");
            }
            case 9 -> {
                return !arr[0][2].equals("-");
            }
            default -> {
                return true;
            }
        }
    }

    public static boolean win(String[][] arr, String player) {

        for (int i = 0; i < 3; i++) {
            if ((arr[i][0].equals(player) && arr[i][1].equals(player) && arr[i][2].equals(player)) ||
                    (arr[0][i].equals(player) && arr[1][i].equals(player) && arr[2][i].equals(player))) {
                return true;
            }
        }
        if ((arr[0][0].equals(player) && arr[1][1].equals(player) && arr[2][2].equals(player) ||
                arr[0][2].equals(player) && arr[1][1].equals(player) && arr[2][0].equals(player))) {
            return true;
        }
        return false;
    }

    public static boolean draw(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void makeMove(String[][] arr, int choice, String player) {
        switch (choice) {
            case 1 -> bottomLeft(arr, player);
            case 2 -> bottomMid(arr, player);
            case 3 -> bottomRight(arr, player);
            case 4 -> midLeft(arr, player);
            case 5 -> midMid(arr, player);
            case 6 -> midRight(arr, player);
            case 7 -> topLeft(arr, player);
            case 8 -> topMid(arr, player);
            case 9 -> topRight(arr, player);
            default -> {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
                Please enter a choice:
                1: Bottom left
                2: Bottom Mid
                3: Bottom right
                4: Middle Left
                5: Middle Mid
                6: Middle Right
                7: Top Left
                8: Top Mid
                9: Top Right
                """);
    }

    public static void topLeft(String[][] arr, String input) {
        arr[0][0] = input;
    }

    public static void midLeft(String[][] arr, String input) {
        arr[1][0] = input;
    }

    public static void bottomLeft(String[][] arr, String input) {
        arr[2][0] = input;
    }
    public static void topMid(String[][] arr, String input) {
        arr[0][1] = input;
    }

    public static void midMid(String[][] arr, String input) {
        arr[1][1] = input;
    }

    public static void bottomMid(String[][] arr, String input) {
        arr[2][1] = input;
    }

    public static void topRight(String[][] arr, String input) {
        arr[0][2] = input;
    }

    public static void midRight(String[][] arr, String input) {
        arr[1][2] = input;
    }

    public static void bottomRight(String[][] arr, String input) {
        arr[2][2] = input;
    }
}
