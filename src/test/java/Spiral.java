import java.util.*;

class Spiral {

    // Function to print in spiral order
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int nRow = A.size(), nCol = A.get(0).size();
        String dir = "Right";
        int row = 0, col = 0, layer = 0;
        if (nRow == 0)
            return result;
        result.add(A.get(0).get(0));
        for (int step = 1; step < nRow * nCol; step++) {
            switch (dir) {
                case "Right":
                    if (col == nCol - layer - 1) {
                        row++;
                        dir = "Down";
                    } else
                        col++;
                    break;
                case "Down":
                    if (row == nRow - layer - 1) {
                        dir = "Left";
                        col--;
                    } else
                        row++;
                    break;
                case "Left":
                    if (col == layer) {
                        dir = "Up";
                        row--;
                    } else
                        col--;
                    break;
                case "Up":
                    if(row==layer+1)
                    {
                        dir="Right";
                       layer++;
                       col++;
                    }else
                    row--;
                    break;
            }
            result.add(A.get(row).get(col));
        }
        return  result;
    }

    // Driver Code
    public static void main(String[] args) {
        int count = 0;
        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i < 4; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                a.add(++count);
            }
            A.add(a);
        }

        System.out.println(new Spiral().spiralOrder(A));
    }
}