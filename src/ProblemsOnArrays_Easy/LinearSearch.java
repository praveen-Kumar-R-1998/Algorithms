package ProblemsOnArrays_Easy;

/**
 * Find if the given number is present it array or not
 */
public class LinearSearch {

    public static void approach_1(int[] arr, int size,int number){

        boolean flag =false;
        for(int i=0; i<size; i++){
            if(arr[i]==number){
                System.out.println("The number "+number+" occurs at position "+i+" in the given array which is a 0 based index.");
                flag=true;
                break;
            }

        }
        if(!flag){
            System.out.println("The number "+number+" is not present in the given array");
        }
    }

    public static void main(String[] args) {
        int[] arr = {11,12,13,14,15,16,17,18,19};
        int size = arr.length;
        int number = 15;
        approach_1(arr, size,number);
    }

}

