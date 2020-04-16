package com.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import com.veterinaria.dao.articulo.Articulo;
import com.veterinaria.repository.IArticuloRepository;

import org.springframework.http.MediaType;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200") //  PARA PRODUCCION ELIMINAR
@RestController
@RequestMapping({ "/articulo" })
public class ArticuloController {


        @Autowired
        private IArticuloRepository iArticuloRepository;
 


        @PostMapping
        public Articulo setArticulo(@RequestBody Articulo articulo ) {

            iArticuloRepository.save(articulo);
            return articulo;
        } 
 
        @GetMapping(value="/articulos")
        public List<Articulo> getArticulos() {
            return iArticuloRepository.findAll();
        } 

        @GetMapping(value="/articulo")
        public Optional<Articulo> getArticuloById(@RequestParam(name = "id") Long id) {
            return   iArticuloRepository.findById(id);
        } 

        @GetMapping(value="/articulo/by/id")
        public Optional<Articulo> getArticuloByNombre(@RequestParam(name = "id") Long id) {
            return   iArticuloRepository.findById(id);
        } 

        @GetMapping(value="/articulo/by/nombre")
        public List<Optional<Articulo>> getArticuloByNombre(@RequestParam(name = "nombre") String nombre) {
            return   iArticuloRepository.findByNombreContaining(nombre);
        } 

        @PutMapping(value = "/articulo") 
        public Articulo udateArticulo(@RequestBody Articulo articulo) { 
            iArticuloRepository.save(articulo);
            return articulo;
            }

    }