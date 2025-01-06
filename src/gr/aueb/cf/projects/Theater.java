package gr.aueb.cf.projects;

public class Theater {

    private static final int ROWS = 30;
    private static final int COLS = 12;
    private boolean[][] seats = new boolean[ROWS][COLS];

    public static void main(String[] args) {

        Theater theater = new Theater();
        theater.book('A', 1);
        theater.book('B', 5);
        theater.print2DArray();
        theater.book('A', 1);
    }

    public void print2DArray() {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                char status = seats[i][j] ? 'B' : 'A';
                System.out.print((char)('A' + j) + Integer.toString(i + 1) + ":" + status + " ");
            }
            System.out.println();
        }
    }

    public void book(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;

        if (rowIndex >= 0 && rowIndex < ROWS && colIndex >= 0 && colIndex < COLS) {
            if (!seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = true;
                System.out.println("Seat " + column + row + " has been booked.");
            } else {
                System.out.println("Seat " + column + row + " is already booked.");
            }
        } else {
            System.out.println("Invalid seat.");
        }
    }

    public void cancel(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;

        if (rowIndex >= 0 && rowIndex < ROWS && colIndex >= 0 && colIndex < COLS) {
            if (!seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = false;
                System.out.println("Booking for seat " + column + row + " has been canceled");
            }else {
                System.out.println("Seat " + column + row + " is not booked.");
            }
        } else  {
            System.out.println("Invalid seat");
        }
    }
}
