import java.io.OutputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.OptionalInt;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lucasr
 */
public class newH {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            final String regex = "xs_and_os_.*input[.]txt";
            File directory = new File(".");
            File[] candidates = directory.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.matches(regex);
                }
            });
            File toRun = null;
            for (File candidate : candidates) {
                if (toRun == null || candidate.lastModified() > toRun.lastModified())
                    toRun = candidate;
            }
            inputStream = new FileInputStream(toRun);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("xs_and_os_output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BXsAndOs solver = new BXsAndOs();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class BXsAndOs {
        public void solve(int testNumber, MyScanner sc, PrintWriter out) {
            int N = sc.nextInt();
            char[][] table = new char[N][];
            for (int i = 0; i < N; i++) {
                table[i] = sc.next().toCharArray();
            }
            int[] needI = new int[N], needJ = new int[N];
            Arrays.fill(needI, N + 1);
            Arrays.fill(needJ, N + 1);
            for (int i = 0; i < N; i++) {
                boolean can = true;
                int need = 0;
                for (int j = 0; j < N; j++) {
                    if (table[i][j] == '.') need++;
                    else if (table[i][j] == 'O') can = false;
                }
                if (can) {
                    needI[i] = need;
                }
            }
            for (int i = 0; i < N; i++) {
                boolean can = true;
                int need = 0;
                for (int j = 0; j < N; j++) {
                    if (table[j][i] == '.') need++;
                    else if (table[j][i] == 'O') can = false;
                }
                if (can) {
                    needJ[i] = need;
                }
            }
            int ans = Math.min(Arrays.stream(needI).min().getAsInt(), Arrays.stream(needJ).min().getAsInt());
            int count = 0;
            if (ans <= N) {
                if (ans == 1) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (table[i][j] == '.' && (needI[i] == 1 || needJ[j] == 1)) count++;
                        }
                    }
                } else {
                    count = (int) Arrays.stream(needI).filter(i -> i == ans).count() + (int) Arrays.stream(needJ).filter(i -> i == ans).count();
                }
            }
            out.println("Case #" + testNumber + ": " + (ans > N ? "Impossible" : ans + " " + count));
        }

    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

