package com.geek.spring.les1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class ProductRepository {
private  List<Product>  products;

@PostConstruct
    public void init(){
        products = new ArrayList<Product>(Arrays.asList(
                    new Product(1L, "loaf", 10L),
                    new Product(2L, "hamburger", 20L),
                    new Product(3L, "pastry", 30L),
                    new Product(4L, "tin", 40L),
                    new Product(5L, "flour", 60L)
        ));
    }

    public List<Product> listInfo(){
    return Collections.unmodifiableList(products);
    }
    public List<Product> listInfo(long id){
    return products.stream().filter(product -> product.getId()==id).collect(Collectors.toList());
    }
    public void addProduct(String name, long price){
    long maxId=0;
    for (Product p:products){
        if (p.getId()>maxId){
            maxId=p.getId();
        }
    }
        products.add(new Product(maxId, name, price));
    }
    public boolean removProduct(long id){
        for (Product p:products){
            if (p.getId()==id){
                products.remove(p);
                return true;
            }
        }
        return false;
    }
}
