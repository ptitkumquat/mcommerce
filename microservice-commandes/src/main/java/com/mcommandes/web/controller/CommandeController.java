package com.mcommandes.web.controller;


import com.mcommandes.configuration.ApplicationPropertiesConfiguration;
import com.mcommandes.dao.CommandesDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    CommandesDao commandesDao;

    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    @PostMapping (value = "/commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){

        Commande nouvelleCommande = commandesDao.save(commande);

        if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }


    @GetMapping(value = "/commandes/{id}")
    public List<Commande> recupererUneCommande(@PathVariable int id){

        Optional<Commande> commande = commandesDao.findById(id);

        List<Commande> listeCommande = commandesDao.findAll();

        List<Commande> listeCommandeLimitee = listeCommande.subList(0, appProperties.getLimitDeCommande());

        if(!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");

        return listeCommandeLimitee;
    }
}
