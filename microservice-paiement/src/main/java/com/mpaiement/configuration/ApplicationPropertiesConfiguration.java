package com.mpaiement.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-configs")
public class ApplicationPropertiesConfiguration {

    private int montantFixe;

    public int getMontantFixe() {
        return montantFixe;
    }

    public void setMontantFixe(int montantFixe) {
        this.montantFixe = montantFixe;
    }
}

