package ProblemsOnArrays_Easy;

public class LeftRotateAnArrayByOnePlace {

    public static void approach_1(int[] arr, int size){
        if(size==1){
            System.out.println("Array has only one element, Left rotate will be ineffective and no visible changes will be displayed");
            return;
        }
        int temp = arr[0];
        for(int i=0; i<size-1; i++){
            arr[i]=arr[i+1];
        }
        arr[size-1]=temp;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int size = arr.length;
        System.out.println("Array before left rotation");

        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        approach_1(arr,size);

        System.out.println("Array After left rotation");

        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
