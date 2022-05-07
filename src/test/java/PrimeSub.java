import java.util.ArrayList;

public class PrimeSub {

    public static void main(String[] args) {
        System.out.println(new PrimeSub().primesum(16777214));
    }

//    public ArrayList<Integer> primesum(int A)
//    {
//        ArrayList<Integer> Arr=new ArrayList<>();
//        for(int i=2;i<=A/2;i++)
//        {
//            if(pr(i)==true &&pr(A-i)==true)//check if both are prime or not
//            {
//                Arr.add(i);
//                Arr.add(A-i);
//                break;//As checking starts from 2, we always get lexicographically smaller
//            }
//        }
//        return Arr;
//    }
//    public boolean pr(int n)
//    {
//        for(int i=2;i*i<=n;i++)
//        {
//            if(n%i==0)
//                return false;//As soon as factor is found break as its not prime
//        }
//        return true;
//    }

    public ArrayList primesum(int A) {

        ArrayList<Integer> a = new ArrayList<Integer>();

        for(int i=2; i<A;i++)
        {
            if(isPrime(i)&&isPrime(A-i))
            {
                a.add(i);
                a.add(A-i);
                break;
            }
        }


        return a;
    }

    public boolean isPrime(int n)
    {
        if(n==2)
            return true;
        for(int i=2; i<n; i++)
        {
            if(n%i==0)
            {
                return false;

            }
        }

        return true;
    }

}
