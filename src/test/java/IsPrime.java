import java.util.ArrayList;
import java.util.Collections;

public class IsPrime {


    public static void main(String[] args) {
        ArrayList<Integer> a = new IsPrime().sieve(11);
        for (int i : a)
            System.out.println(i);
    }
    public ArrayList sieve(int A) {

        ArrayList primeArrayList = new ArrayList();

        int sqrtA = (int) Math.sqrt(A);

        int[] sieve = new int[A + 1];

        for(int i = 2;i <= sqrtA;i++) {

            if(sieve[i] == 0) {

                for(int j = 2;j <= A/i;j++) {

                    sieve[j * i] = 1;

                }

            }

        }

        for(int i = 2;i <= A;i++) {

            if(sieve[i] == 0) {

                primeArrayList.add(i);

            }

        }

        return primeArrayList;

    }
}
