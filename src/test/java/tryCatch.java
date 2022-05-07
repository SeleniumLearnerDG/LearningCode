public class tryCatch {
    public static void main(String[] args) {

        try{
            java();
        }
        catch(Exception e)
        {
            System.out.println("hi exception");
        }

        python();
    }

    private static void java() {
        try {
            System.out.println("Hi Java");
            throw new RuntimeException("thow");
        }
        finally {
            System.out.println("finally java");
        }
    }

    private static void python() {
        try {
            System.out.println("Hi python");
            return;
        }
        finally {
            System.out.println("finally python");
        }
    }

}

