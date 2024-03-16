//https://www.codewars.com/kata/565f5825379664a26b00007c
public class Kata {
    public static int[] getSize(int w,int h,int d) {
        int array[] = new int[2];
        array[0] = 2 * (w * h + w * d + h * d);
        array[1] = w * h * d;
        return array;
    }
}
