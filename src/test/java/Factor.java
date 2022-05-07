import java.util.ArrayList;

public class Factor {

    public ArrayList allFactors(int A) {

        ArrayList temp = new ArrayList<>();

        for (int i=1;i*i<A;i++){

            if (A%i == 0)

                temp.add(i);

        }

        for (int i=(int)Math.sqrt(A);i>=1;i--){

            if (A%i==0) temp.add(A/i);

        }

        return temp;

    }



    public static void main(String[] args) {
        System.out.println(new Factor().allFactors(98145448));
    }
}
