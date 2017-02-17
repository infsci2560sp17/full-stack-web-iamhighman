/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.controllers;

import edu.infsci2560.models.Book;
import edu.infsci2560.repositories.BookRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kolobj
 */
@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    
    //@RequestMapping(value = "book", method = RequestMethod.GET)
    //public ModelAndView index() {
    //    return new ModelAndView("book", "book", repository.findAll());
    //}

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("book", "book", repository.findAll());
		
        Iterable<Book> books = repository.findAll();
        int sumprice = 0;
        for(Book b:books) {
           sumprice += b.getBookPrice();
        }
        
        modelAndView.addObject("sumPrice", sumprice);
 
		return modelAndView;
        //return new ModelAndView("book", "book", repository.findAll());
    }

    
    @RequestMapping(value = "book/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Book book, BindingResult result) {
        repository.save(book);
        ModelAndView modelAndView = new ModelAndView("book", "book", repository.findAll());
        Iterable<Book> books = repository.findAll();
        int sumprice = 0;
        for(Book b:books) {
           sumprice += b.getBookPrice();
        }
        
        modelAndView.addObject("sumPrice", sumprice);
		return modelAndView;
        //return new ModelAndView("book", "book", repository.findAll());
    }
    
}