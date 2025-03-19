package ra.validate;

import ra.presentation.CustomerApplication;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static String validateFirstName(Scanner scanner, String firstName, int indexUpdate) {
        do {
            boolean isExist = false;
            for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
                if (CustomerApplication.arrCustomers[i].getFirstName().equals(firstName) && i != indexUpdate) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return firstName;
            }
            System.err.println("Tên khách hàng đã tồn tại, vui lòng nhập lại");
            firstName = scanner.nextLine();
        } while (true);
    }
    public static String validatelastName(Scanner scanner, String LastName, int indexUpdate) {
        do {
            boolean isExist = false;
            for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
                if (CustomerApplication.arrCustomers[i].getLastName().equals(LastName) && i != indexUpdate) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return LastName;
            }
            System.err.println("Tên khách hàng đã tồn tại, vui lòng nhập lại");
            LastName = scanner.nextLine();
        } while (true);
    }

    public static String validateCustomerId(Scanner scanner, String message, String regex) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (Pattern.matches(regex, inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static String isCustomerExist(Scanner scanner, String value, String type) {
        do {
            boolean isExist = false;
            switch (type) {
                case "CustomerId":
                    for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
                        if (CustomerApplication.arrCustomers[i].getCustomerId().equals(value)) {
                            isExist = true;
                            break;
                        }
                    }
                    break;
                case "firstName":
                    for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
                        if (CustomerApplication.arrCustomers[i].getFirstName().equals(value)) {
                            isExist = true;
                            break;
                        }
                    }
                    break;
            }
            if (!isExist) {
                return value;
            }
            System.err.println("Dữ liệu bị trùng lặp, vui lòng nhập lại");
            value = scanner.nextLine();
        } while (true);

    }
}
