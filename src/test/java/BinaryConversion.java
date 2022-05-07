public class BinaryConversion {
    public static void main(String[] args) {
        System.out.println(new BinaryConversion().findDigitsInBinary(9));
    }
    public String findDigitsInBinary(int A) {
        String buff="";
        while(A/2!=0)
        {
            buff=(A%2)+buff;
           A=A/2;
        }
        buff=A+buff;
        return buff;
    }
}
