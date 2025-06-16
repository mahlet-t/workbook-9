package com.Pluralsight.NorthwindTradersSpringBoot;

import com.Pluralsight.NorthwindTradersSpringBoot.Dao.IProductDao;
import com.Pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Ui implements CommandLineRunner {
    @Autowired
    private IProductDao productDao;

    @Override
    public void run(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1)List products");
            System.out.println("2)Add Products");
            System.out.println("3)Exit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    for (Product product : productDao.getAll()) {
                        System.out.println(product.getProductId() + "-" + product.getName() + "-" + product.getCategory()
                                + "-" + product.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = input.nextLine();

                    System.out.print("Enter category: ");
                    String category = input.nextLine();

                    System.out.print("Enter price: ");
                    double price = input.nextDouble();
                    input.nextLine();

                    productDao.add(new Product(0, name, category, price));
                    System.out.println("Product added!");
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting app.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }


    }


}
