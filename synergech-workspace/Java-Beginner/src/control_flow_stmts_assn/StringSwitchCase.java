package control_flow_stmts_assn;

import java.util.Scanner;

public class StringSwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        classifyItem(input);
    }

    public static void classifyItem(String item) {
        switch (item.toLowerCase()) {
            case "apple":
            case "orange":
            case "grape":
                System.out.println("This is a fruit.");
                break;
            case "potato":
            case "onion":
                System.out.println("This is a vegetable.");
                break;
            default:
                System.out.println("I cannot classify this as a fruit or vegetable.");
        }
    }
}