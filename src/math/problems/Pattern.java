package math.problems;

public class Pattern {

    public static void main(String[] args) {
        /*
        Read the numbers below, find the pattern, then implement the logic from this pattern.
            Once done, you should test to see if you get the same output as below:

        100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32...

        */

        findPattern(100);

    }

    public static void findPattern(int start){
        int n = 1;
        System.out.print(start + ",");
        for (int i = start; start >= 0; i--) {
            if (start < 0) {
                break;
            }
            for (int j = 10; j > 0; j--) {
                start = start -n;
                if (start < 0) {
                    break;
                }
                System.out.print((start) + ",");
            }
            n++;
        }
        }



    }


