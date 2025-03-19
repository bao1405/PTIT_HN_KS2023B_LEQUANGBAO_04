package ra.validate;

import java.util.Scanner;
public class validator {
    private static StringRule stringRule;

    public static String validateInputString(Scanner scanner, String message, StringRule StringRule ) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (stringRule.isValidString(inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static int validateInputInt(Scanner scanner, String message) {
        System.out.println(message);
        do {
            if (!scanner.hasNextInt()) {
                //Không phải số nguyên
                System.err.println("Dữ liệu không phải số nguyên, vui lòng nhập lại");
                scanner.nextLine();
                continue;
            }
            //Là số nguyên
            return Integer.parseInt(scanner.nextLine());
        } while (true);
    }

    public static boolean validateInputBoolean(Scanner scanner, String message) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(inputString);
            }
            System.err.println("Kiểu dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static float validateInputFloat(Scanner scanner, String message, float minValue) {
        System.out.println(message);
        do {
            if (!scanner.hasNextFloat()) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
                scanner.nextLine();
                continue;
            }
            float number = Float.parseFloat(scanner.nextLine());
            if (number > minValue) {
                return number;
            }
            System.err.printf("Giá trị phải lớn hơn %f, vui lòng nhập lại\n", minValue);
        } while (true);
    }
}
