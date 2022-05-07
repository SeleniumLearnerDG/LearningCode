import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A1Chapter1 {

    static final String filename = "weak_typing_chapter_1_input";

    public static void solution_A1Chapter1(Scanner fs, PrintWriter out) {
        int numberOfCases = fs.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            int length = fs.nextInt();
            String in = fs.next();
            int count = 0;
            String ch = null;
            if (length > 2)
                for (int j = 0; j < length; j++) {
                    if (in.charAt(j) == 'F')
                        continue;
                    else if (ch == null) {
                        ch = in.charAt(j) + "";
                    } else if (!ch.equalsIgnoreCase(in.charAt(j) + "")) {
                        count++;
                        ch = in.charAt(j) + "";
                    }
                }
            out.println("Case #" + (i + 1) + ": " + count);

        }
        out.close();
    }


    public static void main(String[] args) throws FileNotFoundException {

        solution_A1Chapter1(new Scanner(new File(filename + ".txt")), new PrintWriter(new File(filename + ".out")));


    }

}
