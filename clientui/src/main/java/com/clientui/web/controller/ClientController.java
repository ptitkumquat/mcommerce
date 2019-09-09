package com.clientui.web.controller;

import com.clientui.beans.CommandBean;
import com.clientui.beans.ProductBean;
import com.clientui.proxies.MicroserviceCommandProxy;
import com.clientui.proxies.MicroserviceProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    //RequestMapping Product related
    @Autowired
    private MicroserviceProduitsProxy mProduitsProxy;

    @RequestMapping("/")
    public String accueil(Model model){

        List<ProductBean>produits=mProduitsProxy.listeDesProduits();

        model.addAttribute("produits", produits);

        return "Accueil";
    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){

        ProductBean produit=mProduitsProxy.recupererUnProduit(id);

        model.addAttribute("produit", produit);

        return "FicheProduit";
    }

    //RequestMapping Commands related
    @Autowired
    private MicroserviceCommandProxy mCommandProxy;

    @RequestMapping("/commande")
    public String ficheCommande(@PathVariable int id, Model model){

        CommandBean commande=mCommandProxy.recupererUneCommande(id);

        model.addAttribute("commande", commande);

        return "FicheCommande";
    }

    @PostMapping("/passer-commande")
    public void passerCommande(@RequestBody CommandBean commande){

        mCommandProxy.ajouterCommande(commande);
    }


}
