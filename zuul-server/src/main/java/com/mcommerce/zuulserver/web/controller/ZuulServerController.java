package com.mcommerce.zuulserver.web.controller;

import com.mcommerce.zuulserver.configuration.ApplicationPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ZuulServerController {

    @Autowired
    ApplicationPropertiesConfiguration appZuulServProperties;
}
