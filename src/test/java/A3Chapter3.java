import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A3Chapter3 {

    static final String filename = "weak_typing_chapter_3_validation_input";
    static final long mod =1000000007;
    public static void solution_A3Chapter3(Scanner fs, PrintWriter out) {
        int numberOfCases = fs.nextInt();
        for (int m = 0; m < numberOfCases; m++) {
            int length = fs.nextInt();
            char in[] = fs.next().toCharArray();
            int ans=0;
            StringBuffer s = new StringBuffer();
            for(int i=0;i<length;i++)
            {
             if(in[i] == '.')
                {
                    s.append(s);
                }
             else
                {
                    s.append(in[i]);
                }
            }
            in=s.toString().toCharArray();
            if(in.length<10000) {
                for (int j = 0; j < in.length; j++) {
                    int count1 = 0;
                    int count2 = 0;
                    int flag1 = 0;
                    int flag = 0;
                    for (int i = j; i < in.length; i++) {
                        if (flag1 == 0 && in[i] == 'O') {
                            flag1 = 1;
                            count1++;
                        }
                        if (flag1 == 1 && in[i] == 'X') {
                            flag1 = 0;
                            count1++;
                        }
                        if (flag == 0 && in[i] == 'X') {
                            flag = 1;
                            count2++;
                        }
                        if (flag == 1 && in[i] == 'O') {
                            flag = 0;
                            count2++;
                        }
                        long k = Math.min(count1, count2);
                        ans += k;
                        ans %= mod;
                    }
                }
            }
            out.println("Case #" + (m + 1) + ": " + ans);

        }
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        solution_A3Chapter3(new Scanner(new File(filename + ".txt")), new PrintWriter(new File(filename + "_out.txt")));
        //solution_A3Chapter3(new Scanner(System.in), new PrintWriter(System.out));
    }
}
