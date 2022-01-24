package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        return checkRow(board) || checkColumn(board);
    }

    public static boolean checkRow(int[][] board) {
        boolean rsl = true;
        for (int row = 0; row < board.length - 1; row++) {
            for (int cell = 0; cell < board[row].length - 1; cell++) {
                if ((board[row][cell] != 1) && (board[row][cell] != board[row][cell + 1])) {
                    rsl = false;
                    break;
                }
            }
        }

        return rsl;
    }
    public static boolean checkColumn(int[][] board) {
        boolean rsl = true;
        for (int row = 0; row < board.length - 1; row++) {
            for (int cell = 0; cell < board[row].length - 1; cell++) {
                if ((board[row][cell] != 1) && (board[row][cell] != board[row + 1][cell])) {
                    rsl = false;
                    break;
                }
            }
        }

        return rsl;
    }
}
