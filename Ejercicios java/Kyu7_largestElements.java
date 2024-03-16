//https://www.codewars.com/kata/53d32bea2f2a21f666000256
public class Solution {
  
   public static int[] largest(int n, int[] arr) {
     boolean order = false;
     while(!order){
       order = true;
       for(int i = 0 ; i < arr.length - 1 ; i++){
         if(arr[i] > arr[i + 1]){
           int temp = arr[i];
           arr[i] = arr[i + 1];
           arr[i + 1] = temp;
           order = false;
         }
       }
     }
     int array[] = new int[n];
     for(int i = 0 ; i < array.length ; i++){
       array[i] = arr[arr.length + i - n]; 
     }
     return array;
   }
}
