package ra.bussiness;

import ra.entity.Customer;
import ra.presentation.CustomerApplication;
import ra.validate.CustomerValidator;
import ra.validate.validator;
import java.util.Scanner;
import ra.validate.StringRule;

public class CustomerBusiness {
    public static void displayListCustomer() {
        if (CustomerApplication.currentCustomerIndex == 0) {
            System.out.println("Chưa có khách hàng");
            return;
        }
        for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
            CustomerApplication.arrCustomers[i].display();
        }
    }

    public static void addCustomerlog(Scanner scanner) {
        int numberOfCategories = validator.validateInputInt(scanner, "Nhập số danh mục cần nhập thông tin");
        for (int i = 0; i < numberOfCategories; i++) {
            CustomerApplication.arrCustomers[CustomerApplication.currentCustomerIndex] = new Customer[];
            CustomerApplication.arrCustomers[CustomerApplication.currentCustomerIndex].inputData(scanner);
            CustomerApplication.currentCustomerIndex++;
        }
    }

    public static void updateCustomer(Scanner scanner) {
        int catalogId = validator.validateInputInt(scanner, "Nhập vào mã khách hàng");
        int indexUpdate = findIndexById(catalogId);
        if (indexUpdate == -1) {
            System.err.println("Không tồn tại mã danh mục");
            return;
        }
        do {
            System.out.println("1. Cập nhật tên khách hàng");
            System.out.println("2. Cập nhật họ khách hàng");
            System.out.println("3. Cập nhật ngày sinh");
            System.out.println("4. Cập nhật giới tính");
            System.out.println("5. địa chỉ");
            System.out.println("6. số điện thoại");
            System.out.println("7. email");
            System.out.println("0. Thoát");
            int choice = validator.validateInputInt(scanner, "Lựa chọn của bạn");
            switch (choice) {
                case 1:
                    String firstName = validator.validateInputString(scanner, "Nhập tên khach han", new StringRule(6, 50));
                    CustomerApplication.arrCustomers[indexUpdate].setFirstName(CustomerValidator.validateFirstName(scanner, firstName, indexUpdate));
                    break;
                case 2:
                    String lastName = validator.validateInputString(scanner, "Nhập tên khach han", new StringRule(6, 30));
                    CustomerApplication.arrCustomers[indexUpdate].setLastName(CustomerValidator.validatelastName(scanner, lastName, indexUpdate));
                    break;
                case 3:
                    CustomerApplication.arrCustomers[indexUpdate].setDateOfBirth(validator.validateInputString(scanner, "Nhập vào số diện thoại", new StringRule(6, 30)));
                    break;
                case 4:
                    CustomerApplication.arrCustomers[indexUpdate].setGender(validator.validateInputBoolean(scanner, "Nhập vào giới tính"));
                    break;
                case 5:
                    CustomerApplication.arrCustomers[indexUpdate].setPhoneNumber(validator.validateInputString(scanner, "Nhập vào số diện thoại", new StringRule(0, 10)));
                    break;
                case 6:
                    CustomerApplication.arrCustomers[indexUpdate].setEmail(validator.validateInputString(scanner, "Nhập vào email", new StringRule(0, 10)));
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (true);
    }

    public static int findIndexById(int CustomerId) {
        for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
            if (CustomerApplication.arrCustomers[i].getCustomerId() == CustomerId) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteCustomerlog(Scanner scanner) {
        int CustomerId = validator.validateInputInt(scanner, "Nhập vào mã khách hàng cân xóa");
        int indexDelete = findIndexById(CustomerId);
        if (indexDelete == -1) {
            System.err.println("Mã danh mục không tồn tại");
            return;
        }

    }
