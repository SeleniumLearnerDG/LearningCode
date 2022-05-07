import java.io.OutputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lucasr
 */
public class Chapter2 {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            final String regex = "consistency_chapter_2_.*input[.]txt";
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
            outputStream = new FileOutputStream("consistency_chapter_2_output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A2ConsistencyChapter2 solver = new A2ConsistencyChapter2();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class A2ConsistencyChapter2 {
        static final int MAX = 26;
        static final int INF = Integer.MAX_VALUE / 2;

        public void solve(int testNumber, MyScanner sc, PrintWriter out) {
            char[] tmp = sc.next().toCharArray();
            int[] S = new int[tmp.length];
            for (int i = 0; i < S.length; i++) {
                S[i] = tmp[i] - 'A';
            }
            int[][] cost = new int[MAX][MAX];
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    cost[i][j] = INF;
                }
                cost[i][i] = 0;
            }
            int K = sc.nextInt();
            for (int i = 0; i < K; i++) {
                char[] ab = sc.next().toCharArray();
                cost[ab[0] - 'A'][ab[1] - 'A'] = 1;
            }
            GraphLib.floydIn(cost);
            int ans = INF;
            for (int i = 0; i < MAX; i++) {
                int cur = 0;
                for (int j = 0; j < S.length; j++) {
                    cur += cost[S[j]][i];
                    if (cur >= INF) break;
                }
                ans = Math.min(ans, cur);
            }
            out.println("Case #" + testNumber + ": " + (ans >= INF ? -1 : ans));
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

    static class GraphLib {
        public static void floydIn(int[][] dist) {
            int n = dist.length;
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

        }

    }
}

