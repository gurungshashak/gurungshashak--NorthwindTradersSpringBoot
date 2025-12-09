package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

   private final Scanner scanner;
    private final ProductDao productDao;

    @Autowired
    public NorthwindApplication(ProductDao productDao) {
        this.productDao = productDao;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======================================\n");
        System.out.println("Welcome To NorthwindTradersSpringBoot");
        System.out.println("\n=======================================");

        while (true) {
            System.out.println("1) \tList Products");
            System.out.println("2) \tAdd Product");
            System.out.println("3) \tDelete Product");
            System.out.println("0) \tQuit");
            System.out.print("Choice From (0-3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":

                    productDao.getAll().forEach(System.out::println);
                    break;
                case "2":

                    System.out.print("\nproductId: ");
                    int productId = scanner.nextInt();
                    System.out.print("\nName: ");
                    String name = scanner.next();
                    System.out.print("\nCategory: ");
                    String category = scanner.next();
                    System.out.print("\nPrice: ");
                    double price = scanner.nextDouble();

                    productDao.add(new Product(productId, name, category, price));
                    System.out.println("\n====================================\n");
                    System.out.println("\tProduct Added Successfully!!");
                    System.out.println("\n====================================\n");
                    scanner.nextLine();
                    break;
                case "3":
                    productDao.delete();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid Choice!!\n");
            }
        }
    }
}
