package com.cts.sbjpa.sbjpa12.service;


import com.cts.sbjpa.sbjpa12.entity.Product;
import com.cts.sbjpa.sbjpa12.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository pRepository;

    //Create a product
    public Product saveProduct(Product product){
        logger.debug("product name received to be saved"+ product.getName());
        return pRepository.save(product);
    }
    //Retieving
    public Product getProductById(int id){
        logger.debug("finding by id ...." + id);
        return pRepository.findById(id).orElse(null);

    }


    //Deleting
    public String deleteProductById(int id){
        pRepository.deleteById(id);
        return "product deleted,{},id";

    }
    //updating
    public Product updateProduct(Product product){
        Product updateProduct=pRepository.getById(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setQuantity(product.getQuantity());
        return pRepository.save(updateProduct);
    }


}
