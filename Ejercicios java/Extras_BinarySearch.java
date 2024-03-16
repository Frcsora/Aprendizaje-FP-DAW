package binarysearch;
import java.util.*;
import java.util.stream.*;

public class BinarySearch {

    public static void main(String[] args) {
        
        int n = 40000;
        
        List<Integer> lista = new ArrayList<Integer>();
        lista = Stream.iterate(Integer.MAX_VALUE / 10 + 1, i -> i + 1).limit(100000)
                    .collect(Collectors.toList());



        int start = 0;
        int finish = lista.size();

        boolean find = false;
        
        int middle;
        while (!find) {
            middle = (finish + start) / 2;
            System.out.println(middle);
            if (n < middle) {
                finish = middle;
            } else if (n > middle) {
                start = middle;
            } else {
                find = true;
            }
        }
    }
}
