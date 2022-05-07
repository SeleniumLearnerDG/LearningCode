import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HaimmingDistance {
    public static void main(String[] args) {
        List<Integer> A= new ArrayList<Integer>(Arrays.asList(2,4,6)) ;
        System.out.println(new HaimmingDistance().hammingDistance(A));
    }

    public int hammingDistance(final List<Integer> A) {
        long ans = 0, n=A.size();
        for (int i = 0; i < 32; i++) {
            int count = 0; // number of elements with ith bit set
            for (int j = 0; j < n; j++)
                if ( (A.get(j) & (1 << i)) ==0)
                    count++;
            ans += count * (n - count) * 2; // mul by 2 because {1,2} and {2,1} different pairs
        }
        return (int)(ans % 1000000007);
    }
}
