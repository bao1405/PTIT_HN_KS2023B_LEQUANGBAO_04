package ra.presentation;

import ra.entity.Customer;
import java.util.Scanner;
import ra.validate.validator;
import ra.bussiness.CustomerBusiness;
public class CustomerApplication {
    public static final Customer[] arrCustomers = new Customer[100];
    public static int currentCustomerIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayCustomerMenu(scanner);
    }

    public static void displayCustomerMenu(Scanner scanner) {
        do {
            System.out.println("***************CUSTOMER MENU*******************");
            System.out.println("1. hiện thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát");
            int choice = validator.validateInputInt(scanner, "Lựa chọn của bạn");
            switch (choice) {
                case 1:
                    CustomerBusiness.displayListCustomer();
                    break;
                case 2:
                    CustomerBusiness.addCustomerlog(scanner);
                    break;
                case 3:
                    CustomerBusiness.updateCustomer(scanner);
                    break;
                case 4:
                    CustomerBusiness.deleteCustomerlog(scanner);
                    break;
                case 5:
                    displayShareMenu(scanner);
                    break;
               case 6:
                   break;
               case 0:
                   System.out.println("Kết thúc chương trình");
                   scanner.close();
                   System.exit(0);
                   default:
                       System.err.println("Vui lòng chọn từ 0-6");
                }
            } while (true);
        }
    public static void displayShareMenu(Scanner scanner) {
        do {
            System.out.println("***********CATEGORIES MANAGEMENT*****************");
            System.out.println("1. Tìm kiếm theo tên khách hàng");
            System.out.println("2. Tìm kiếm theo loại khách hàng");
            System.out.println("3. Tìm kiếm theo số điện thoại");
            System.out.println("4. Quay lại Customers Menu");
            int choice = validator.validateInputInt(scanner, "Lựa chọn của bạn");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                   break;
                case 4:
                     return;
                default:
                    System.err.println("Vui lòng chọn từ 1-4");
                }
            } while (true);
        }
}
