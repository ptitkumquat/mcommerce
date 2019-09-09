package com.clientui.proxies;


import com.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="microservice-produits", url="localhost:9001")
public interface MicroserviceProduitsProxy {

    @GetMapping(value="/Produits")
    List<ProductBean>listeDesProduits();


}
