package com.geek.spring.les1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Cart cart = context.getBean("cart", Cart.class);
        Scanner scan = new Scanner(System.in);
        boolean start = true;
        while (start) {
            System.out.println("1. Creat cart \n" +
                    "2. Info All\n" +
                    "3. Info id\n" +
                    "4. Add product\n" +
                    "5. Remuve product\n" +
                    "6. Exit");

            System.out.println("Run command");
            int com = scan.nextInt();
            switch (com) {
                case 1: {
                    cart = context.getBean("cart", Cart.class);
                    break;
                }
                case 2: {
                    System.out.println(cart.listInfo());
                    break;
                }
                case 3: {
                    System.out.println("run id product");
                    long id = scan.nextLong();
                    System.out.println(cart.listInfo(id));
                    break;
                }
                case 4: {
                    System.out.println("run name");
                    String name = scan.nextLine();
                    System.out.println("run price");
                    long price = scan.nextLong();
                    cart.addProduct(name, price);
                    break;
                }
                case 5: {
                    System.out.println("remove product in cart");
                    long id = scan.nextLong();
                    cart.removProduct(id);
                    break;
                }
                case 6: {
                    start = false;
                    break;
                }
            }
        }
        context.close();
    }
}
