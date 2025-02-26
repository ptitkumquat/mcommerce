package com.clientui.proxies;

import com.clientui.beans.CommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="microservice-commandes", url="localhost:9002")
public interface MicroserviceCommandProxy {

    @GetMapping(value="/commandes/{id}")
    CommandBean recupererUneCommande(@PathVariable("id") int id);

    @PostMapping(value="/commandes")
    ResponseEntity<CommandBean> ajouterCommande(@RequestBody CommandBean commande);

}
