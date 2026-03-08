import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true){
            System.out.println("Input your age: ");
            String input = sc.nextLine();
            try {
                if(input.isEmpty()){
                    System.out.println("Content is empty");
                }else {
                    int age = Integer.parseInt(input);
                    System.out.println("Age: " + age);
                    break;
                }
            }catch (Exception e){
                System.out.println("Age is not valid, input again..");
            }
        }

    }
}