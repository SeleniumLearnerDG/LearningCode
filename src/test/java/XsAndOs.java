import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XsAndOs {

    public static void solution_XsAndOs(Scanner fs, PrintWriter out) {
        int numberOfCases = fs.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            int total_noInputRow = fs.nextInt();
            char matrix[][] = new char[total_noInputRow][];
            for (int j = 0; j < total_noInputRow; j++) {
                matrix[j] = fs.next().toCharArray();
            }
            int possibiltyI[] = new int[total_noInputRow], possibilityJ[] = new int[matrix[0].length];
            Arrays.fill(possibiltyI, total_noInputRow + 1);
            Arrays.fill(possibilityJ, total_noInputRow + 1);
            for (int j = 0; j < total_noInputRow; j++) {
                Boolean can = true;
                int need = 0;

                for (int m = 0; m < total_noInputRow; m++) {
                    if (matrix[m][j] == '.') need++;
                    else if (matrix[m][j] == 'O') can = false;
                }

                if (can)
                    possibiltyI[j] = need;

            }


            for (int j = 0; j < total_noInputRow; j++) {
                Boolean can = true;
                int need = 0;
                for (int m = 0; m < total_noInputRow; m++) {
                    if (matrix[j][m] == '.') need++;
                    else if (matrix[j][m] == 'O') can = false;
                }

                if (can)
                    possibilityJ[j] = need;

            }
            int ans = Math.min(Arrays.stream(possibiltyI).min().getAsInt(), Arrays.stream(possibilityJ).min().getAsInt());
            int count =0;
            if (ans <= total_noInputRow) {
                if (ans == 1) {
                    for (int j = 0; j < total_noInputRow; j++) {
                        for (int m = 0; m < total_noInputRow; m++) {
                            if (matrix[j][m] == '.' && (possibiltyI[j] == 1 || possibilityJ[j] == 1)) count++;

                        }
                    }
                    }
                else
                {
                    count = (int) Arrays.stream(possibiltyI).filter(j -> j == ans).count() + (int) Arrays.stream(possibilityJ).filter(j -> j == ans).count();
                }
                out.println("Case #" + (i + 1) + ": " + ans+ " "+ count);
            }
            else
                out.println("Case #" + (i + 1) + ": Impossible");

        }
        out.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        solution_XsAndOs(new Scanner(System.in), new PrintWriter(System.out));

    }


}

