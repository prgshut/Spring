package com.geek.spring.les3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean start = true;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        while (start) {
            System.out.println("1. All client \n" +
                    "2. All products\n" +
                    "3. Clien By\n" +
                    "4. Product By\n" +
                    "5. Remuve client\n" +
                    "6. Remuve product\n" +
                    "7. Exit");

            System.out.println("Run command");
            int com = scan.nextInt();
            switch (com) {
                case 1: {
                    session = factory.getCurrentSession();
                    session.beginTransaction();
                    List<Client> client = session.createQuery("select c from Client  c").getResultList();
                    System.out.println(client);
                    session.getTransaction().commit();
                    break;
                }
                case 2: {
                    session = factory.getCurrentSession();
                    session.beginTransaction();
                    List<Products> products = session.createQuery("select p from Products p").getResultList();
                    System.out.println(products);
                    session.getTransaction().commit();
                    break;
                }
                case 3: {
                    System.out.println("id client");
                    int id = scan.nextInt();
                    session=factory.getCurrentSession();
                    session.beginTransaction();
                    Client client = session.get(Client.class,id);
                    System.out.println(client.getName());
                    for(Products p :client.getLisrProduct()){
                        System.out.println(p);
                    }
                    session.getTransaction().commit();
                    break;
                }
                case 4: {
                    System.out.println("id product");
                    int id = scan.nextInt();
                    session=factory.getCurrentSession();
                    session.beginTransaction();
                    Products product = session.get(Products.class,id);
                    System.out.println(product.getTitle());
                    for(Client c :product.listClient){
                        System.out.println(c);
                    }
                    session.getTransaction().commit();
                    break;
                }
                case 5: {
                    System.out.println("id client");
                    int id = scan.nextInt();
                    session=factory.getCurrentSession();
                    session.beginTransaction();
                    String s = String.format("DELETE FROM Client c WHERE c.id = %d",id);
                    session.createQuery(s).executeUpdate();
                    session.getTransaction().commit();
                    break;
                }
                case 6: {
                    System.out.println("id product");
                    int id = scan.nextInt();
                    session=factory.getCurrentSession();
                    session.beginTransaction();
                    String s = String.format("DELETE FROM Products p WHERE p.id = %d",id);
                    session.createQuery(s).executeUpdate();
                    session.getTransaction().commit();
                    break;
                }
                case 7: {
                    start = false;
                    factory.close();
                    break;
                }
            }
        }
        if (session!=null){
            session.close();
        }
       if (factory!=null){
           factory.close();
       }
    }

}
