package ThuchanhJavaAdvanced_Session05;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ProductManagerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        int choice;
        do{
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM=========\n" +
                    "1. Thêm sản phẩm mới\n" +
                    "2. Hiển thị danh sách sản phẩm\n" +
                    "3. Cập nhật số lượng theo ID\n" +
                    "4. Xóa sản phẩm đã hết hàng\n" +
                    "5. Thoát chương trình \n" +
                    "============================================= ");
            System.out.println("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("== THÊM MỚI SẢN PHẨM ==");
                    Product newProduct = new Product();
                    while (true){
                        System.out.println("Nhập id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        boolean idExisted = false;
                        for (Product p : products){
                            if(p.getId() == id){
                                idExisted = true;
                                throw new InvalidProductException();
                            }

                        }
                        if(!idExisted){
                            newProduct.setId(id);
                            break;
                        }
                    }

                    while (true){
                        System.out.println("Nhập tên sản phẩm: ");
                        String name = sc.nextLine();
                        if(name.isEmpty()){
                            System.out.println("Vui lòng không để trống");
                        }else{
                            newProduct.name = name;
                            break;
                        }

                    }

                    while (true){
                        System.out.println("Nhập giá sản phẩm: ");
                        double price = sc.nextDouble();

                        if(price < 0){
                            System.out.println("Vui lòng nhập giá tiền hợp lệ");
                        }else{
                            newProduct.price = price;
                            break;
                        }
                    }

                    while (true){
                        System.out.println("Nhập số lượng tồn kho: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        if(quantity < 0){
                            System.out.println("Vui lòng số lượng hợp lệ");
                        }else{
                            newProduct.quantity = quantity;
                            break;
                        }
                    }

                    while (true){
                        System.out.println("Nhập danh mục sản phẩm: ");
                        String category = sc.nextLine();

                        if(category.isEmpty()){
                            System.out.println("Vui lòng nhập danh mục sản phẩm");
                        }else{
                            newProduct.category = category;
                            break;
                        }
                    }

                    System.out.println("Thêm mới sản phẩm thành công!!");
                    break;
                case 2:
                    // Hiển thị danh sách sản phẩm
                    if (products.isEmpty()){
                        System.out.println("Danh sách sản phẩm trống");
                        break;
                    }
                    System.out.println("=== DANH SÁCH SẢN PHẨM ===");
                    for (Product p : products){
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    // cập nhật thông tin sản phẩm
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    int targetId = sc.nextInt();
                    sc.nextLine();
                    if(products.isEmpty()) break;

                    //
                    Optional<Product> target = products.stream().filter((Product p) -> p.getId() == targetId).findFirst();

                    if (target.isEmpty()){
                        throw new InvalidProductException();
                    }

                    System.out.println(target.toString());
                    System.out.println("Nhập số lượng cần cập nhật: ");
                    int quantityUd = sc.nextInt();
                    if(quantityUd < 0){
                        System.out.println("Vui lòng nhập số lượng hợp lệ");
                        break;
                    }
                    for (Product p : products){
                        if (p.getId() == targetId){
                            p.quantity = quantityUd;
                            System.out.println("Cập nhật số lượng sản phẩm thành công");
                        }
                    }

                    break;
                case 4:
//                    products = products.stream().filter((Product p) -> p.quantity == 0).toArray();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!!");
                    break;
                default:
                    break;
            }
        }while (choice != 5);

    }
}
