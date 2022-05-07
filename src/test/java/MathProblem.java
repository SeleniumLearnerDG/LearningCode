public class MathProblem {
    public static void main(String[] args) {
       Integer A=16673;
       Integer B= 7444, C=30872;
        System.out.println(new MathProblem().solve(A,B,C));
    }

    public int solve(int A, int B, int C) {
//        int a= C  + (A%B) -1;
        int ans =  (A%B + C -1)%B;
        if (ans==0) return B;
        return ans;


    }

}
