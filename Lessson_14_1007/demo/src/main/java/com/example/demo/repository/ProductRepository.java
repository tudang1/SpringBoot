package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    public ProductRepository(){
       List<Category> listCategory = Arrays.asList(
               new Category(1,"Electronic"),
               new Category(2,"Clothes"),
               new Category(3,"Household")
       );
       listCategory.forEach(c->categories.add(c));

       List<Product> listProduct = new ArrayList<>();
       HashMap<Integer,String> hashMap = new HashMap<>();
        int id = 1;

    }
    public List<Product> getProducts(){return products;}
    public List<Category> getCategories(){return categories;}
    public Optional<Product> get(int id){
        return products.stream().filter(c->c.getId()==id).findFirst();
    }
    public Product create(Product product) {
        int id;
        if (products.isEmpty()) {
            id = 1;
        } else {
            Product lastProduct = products.get(products.size() - 1);
            id = lastProduct.getId() + 1;
        }
        product.setId(id);
        products.add(product);
        return product;
    }
    public Product edit(Product product){
        get(product.getId()).ifPresent(existProduct ->{
            existProduct.setName(product.getName());
            existProduct.setCategory(product.getCategory());
            existProduct.setDetail(product.getDetail());
            existProduct.setPhoto(product.getPhoto());
        });
        return product;
    }
    public void deleteByID(int id){
        get(id).ifPresent(existed ->products.remove(existed));
    }
    public Product search(String name){
        return products.stream().filter(product -> product.getName().contains(name)).findAny().orElse(null);
    }
    public Product searchByCategory(String category){
        return products.stream().filter(product -> product.getCategory().contains(category)).findAny().orElse(null);
    }
}
