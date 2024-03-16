package sort;

public class Sort {

    public static void main(String[] args) {
        int[] orden = {5,3,-5,9,7,7894,1,2,250000,-55};
        boolean order = false;
        while(!order){
            order = true;
            for(int i = 0 ; i < orden.length - 1 ; i++){
                if(orden[i] > orden[i + 1]){
                    int a = orden[i + 1];
                    orden[i + 1] = orden[i];
                    orden[i] = a;
                    order = false;
                }
            }
        }
        
        for (int i = 0 ; i < orden.length ; i++){
            System.out.println(orden[i]);
        }
    }
    
}
