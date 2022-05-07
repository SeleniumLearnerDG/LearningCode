import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chapter1 {
    static final String filename = "consistency_chapter_1_input";

    public static void solution_chapter1(Scanner fs, PrintWriter out) {
        int numberOfCases = fs.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            int totalEffort = 0;
            String in = fs.next();
            if (in.length() > 1) {
                Map<Character, Integer> vowel = new HashMap<Character, Integer>();
                Map<Character, Integer> con = new HashMap<Character, Integer>();
                int maxVow = 0, totalVow = 0, maxCon = 0, totalCon = 0;
                for (int j = 0; j < in.length(); j++) {
                    Character ch = in.charAt(j);
                    if ("AEIOU".contains(ch + "") || "aeiou".contains(ch + "")) {
                        if (vowel.containsKey(ch))
                            vowel.put(ch, vowel.get(ch) + 1);
                        else
                            vowel.put(ch, 1);
                        if (vowel.get(ch) > maxVow)
                            maxVow = vowel.get(ch);
                        totalVow++;
                    } else {
                        if (con.containsKey(ch))
                            con.put(ch, con.get(ch) + 1);
                        else
                            con.put(ch, 1);
                        if (con.get(ch) > maxCon)
                            maxCon = con.get(ch);
                        totalCon++;
                    }
                }
                int timeToVowelConvert = (totalVow - maxVow) * 2 + totalCon;
                int timeToConConvert = (totalCon - maxCon) * 2 + totalVow;
                if (timeToConConvert < timeToVowelConvert)
                    totalEffort = timeToConConvert;
                else
                    totalEffort = timeToVowelConvert;
            }

            out.println("Case #" + (i + 1) + ": " + totalEffort);

        }
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        solution_chapter1(new Scanner(new File(filename + ".txt")), new PrintWriter(new File(filename + ".out")));

    }
}
