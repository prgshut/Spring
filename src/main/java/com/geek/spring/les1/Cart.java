package com.geek.spring.les1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository productRepo;

    @Autowired
    public void setProductRepo(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> listInfo(){
        return productRepo.listInfo();
    }
    public List<Product> listInfo(long id){
        return productRepo.listInfo(id);
    }
    public void addProduct(String name, long price){
        productRepo.addProduct(name,price);
    }
    public void removProduct(long id){
        productRepo.removProduct(id);
    }
}
