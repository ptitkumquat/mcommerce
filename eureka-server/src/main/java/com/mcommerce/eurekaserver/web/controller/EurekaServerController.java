package com.mcommerce.eurekaserver.web.controller;



import com.mcommerce.eurekaserver.configuration.ApplicationPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EurekaServerController {

    @Autowired
    ApplicationPropertiesConfiguration esAppProperties;

    @GetMapping(value="/instances")
    public int recupererInstances(){

        int instances = esAppProperties.getNombreArbitraireInstances();

        return instances;
    }


}
