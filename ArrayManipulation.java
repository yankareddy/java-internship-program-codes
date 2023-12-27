//Array manipulation 

public class ArrayManipulation {
    public static void main(String[] args) {
        /*
         * int[] number = {1,2,3,4);
         * The array declaration is the syntax error
         */
        int[] numbers = { 1, 2, 3, 4 };
        /*
         * for (int i=0,i<=numbers.length;i++)
         * we should use < instead of <= because it will out of boundary
         */
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}