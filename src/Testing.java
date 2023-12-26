import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        System.out.print("Enter a string that u want to convert to string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        for (int i=0; i<s.length(); i++){
            System.out.println(ch[i]);
        }
    }
}
