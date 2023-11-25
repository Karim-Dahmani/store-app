package org.sid.billingservice.service;

import jakarta.ws.rs.Path;
import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path = "/products/{id}")
     Product findProductById(@PathVariable("id") Long Id);
    @GetMapping(path ="/products")
    PagedModel<Product>  allProducts();

}
