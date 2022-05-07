import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A2Chapter2 {
    static final String filename = "weak_typing_chapter_2_input 2";
    static final long mod =1000000007;
    public static void solution_A2Chapter2(Scanner fs, PrintWriter out) {
        int numberOfCases = fs.nextInt();
        for (int m = 0; m < numberOfCases; m++) {
            int length = fs.nextInt();
            StringBuffer in = new StringBuffer();
            in.append(fs.next());
            int ans=0;
            if(in.length()<=800000) {
                for (long j = 0; j < in.length(); j++) {
                    int count1 = 0;
                    int count2 = 0;
                    int flag1 = 0;
                    int flag = 0;
                    for (Long i = j; i < in.length(); i++) {
                        if (flag1 == 0 && in.charAt(Math.toIntExact(i)) == 'O') {
                            flag1 = 1;
                            count1++;
                        }
                        if (flag1 == 1 && in.charAt(Math.toIntExact(i)) == 'X') {
                            flag1 = 0;
                            count1++;
                        }
                        if (flag == 0 && in.charAt(Math.toIntExact(i)) == 'X') {
                            flag = 1;
                            count2++;
                        }
                        if (flag == 1 && in.charAt(Math.toIntExact(i)) == 'O') {
                            flag = 0;
                            count2++;
                        }
                        long k = Math.min(count1, count2);
                        ans += k;
                        ans %= mod;
                    }
                }
                out.println("Case #" + (m + 1) + ": " + ans);
            }

        }
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        solution_A2Chapter2(new Scanner(new File(filename + ".txt")), new PrintWriter(new File(filename + "out.txt")));
    }

}
