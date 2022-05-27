package com.cts.sbjpa.sbjpa12.controller;


import com.cts.sbjpa.sbjpa12.entity.Product;
import com.cts.sbjpa.sbjpa12.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProductController {

    @Autowired
    private ProductService pService;

    Logger logger= LoggerFactory.getLogger(ProductController.class);

    /*
    HTTP methods... post,get,put,delete

     */

    @PostMapping("/newProduct")
    public Product saveNewProduct(@RequestBody Product product){

        return pService.saveProduct(product);
    }
    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable int id){

        logger.debug("id queried is ..."+ id);
        return pService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){

        return pService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id){
        return pService.deleteProductById(id);
    }

}
