package com.mcommerce.eurekaserver.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-configs")
@RefreshScope
public class ApplicationPropertiesConfiguration {

    private int nombreArbitraireInstances;

    public int getNombreArbitraireInstances() {
        return nombreArbitraireInstances;
    }

    public void setNombreArbitraireInstances(int nombreArbitraireInstances) {
        this.nombreArbitraireInstances = nombreArbitraireInstances;
    }
}
