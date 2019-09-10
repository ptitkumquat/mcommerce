package com.mcommandes.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-configs")
@RefreshScope
public class ApplicationPropertiesConfiguration {

    private int limitDeCommande;

    public int getLimitDeCommande() {
        return limitDeCommande;
    }

    public void setLimitDeCommande(int limitDeCommande) {
        this.limitDeCommande = limitDeCommande;
    }
}
