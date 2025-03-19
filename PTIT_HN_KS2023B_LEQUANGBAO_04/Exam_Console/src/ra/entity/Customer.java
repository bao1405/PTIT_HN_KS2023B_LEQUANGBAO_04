package ra.entity;

import java.util.Scanner;
import ra.validate.validator;
import ra.presentation.CustomerApplication;
import ra.validate.CustomerValidator;
import ra.validate.StringRule;
public class Customer implements IApp {
    private String CustomerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer(String customerId, String firstName, String customerType, String email, String phoneNumber, String dateOfBirth, String lastName, boolean gender) {
        CustomerId = customerId;
        this.firstName = firstName;
        this.customerType = customerType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        if (CustomerApplication.currentCustomerIndex == 0) {
            System.err.println("Chưa tồn tại danh sách khách hàng,vui lòng tạo danh sách khách hàng.");
            return;
        }
        this.CustomerId = inputCustomerID(sc);
        this.firstName = inputfirstName(sc);
        this.lastName = inputlastName(sc);
    }

    public String inputCustomerID(Scanner scanner) {
        String productId = CustomerValidator.validateCustomerId(scanner, "Nhập vào mã khách hàng", "[C]\\w{4}");
        return CustomerValidator.isCustomerExist(scanner, productId, "CustromerId");
    }

    public String inputfirstName(Scanner scanner) {
        String productName = validator.validateInputString(scanner, "Nhập vào tên khách hàng", new StringRule(10, 50));
        return CustomerValidator.isCustomerExist(scanner, productName, "CustromerName");
    }

    public String inputlastName(Scanner scanner) {
        String productName = validator.validateInputString(scanner, "Nhập vào họ khch hàng", new StringRule(10, 50));
        return CustomerValidator.isCustomerExist(scanner, productName, "productName");
    }

    public String inputDateofbirth(Scanner scanner) {
        System.out.println("Nhập vào ngày sinh");
        return scanner.nextLine();
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Chọn danh mục của sản phẩm:");
        return scanner.nextLine();
    }

    public int inputGender(Scanner scanner) {
        do {
            System.out.println("Chọn giới tính");
            System.out.println("1. nam");
            System.out.println("2. nữ");
            int choice = validator.validateInputInt(scanner, "Lựa chọn của bạn");
            if (choice >= 1 && choice <= 3) {
                return choice - 1;
            }
            System.err.println("lựa chọn không đúng , vui lòng chọn lại");
        } while (true);

    }
    @Override
    public void display() {
        System.out.println("CustomerId : " + CustomerId);
        System.out.println("FirstName : " + firstName);
        System.out.println("LastName : " + lastName);
        System.out.println("DateOfBirth : " + dateOfBirth);
        System.out.println("Gender : " + gender);
        System.out.println("PhoneNumber : " + phoneNumber);
        System.out.println("Email : " + email);
        System.out.println("CustomerType : " + customerType);
    }

}
