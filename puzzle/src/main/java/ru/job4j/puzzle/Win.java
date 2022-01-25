package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            if (checkRow(board, row) || checkColumn(board, row)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean checkRow(int[][] board, int row) {
        boolean rsl = true;
        for (int cell = 0; cell < board[row].length; cell++) {
                if (board[row][cell] != 1)  {
                    rsl = false;
                    break;
                }
            }
        return rsl;
    }

    public static boolean checkColumn(int[][] board, int cell) {
        boolean rsl = true;
        for (int row = 0; row < board.length; row++) {
                if (board[row][cell] != 1) {
                    rsl = false;
                    break;
                }
            }
        return rsl;
    }
}
