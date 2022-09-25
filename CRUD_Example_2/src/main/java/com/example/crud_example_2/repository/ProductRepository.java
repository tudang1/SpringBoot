package com.example.crud_example_2.repository;

import com.example.crud_example_2.model.Category;
import com.example.crud_example_2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    public ProductRepository(){
        List<Product> listProduct = Arrays.asList(
                new Product(1,"Nuts","Drama","Integer pede justo, lacinia eget, tincidunt eget","movie_1"),
                new Product(2,"Avatar","Drama","Integer pede justo, lacinia eget, tincidunt eget","movie_2"),
                new Product(3,"Avenger: End Game","Crime","Integer pede justo, lacinia eget, tincidunt eget","movie_3"),
                new Product(4,"50 Banh Trung","Action","Integer pede justo, lacinia eget, tincidunt eget","movie_4")
        );
        listProduct.forEach(c->products.add(c));

        List<Category> listCategory = new ArrayList<>();
        HashMap<Integer,String> hashMap = new HashMap<>();
        int id = 1;
        for (Product c : listProduct){
            if (hashMap.isEmpty()){
                hashMap.put(id,c.getCategory());
                listCategory.add(new Category(id, c.getCategory()));
                id++;
            } else if (!hashMap.containsValue(c.getCategory())) {
                hashMap.put(id,c.getCategory());
                listCategory.add(new Category(id, c.getCategory()));
                id++;
            }
        }
        listCategory.forEach(c->categories.add(c));
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
