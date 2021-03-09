package com.cats.spring.controller;

import com.cats.spring.model.Cat;
import com.cats.spring.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @RequestMapping(value = "/addCat", method = RequestMethod.POST)
    public String addCat(@RequestBody Cat cat) {
        System.out.println(cat);
        catService.add(cat);
        return "Ok";
    }

    @RequestMapping(value = "/getCat/{id}", method = RequestMethod.GET)
    public Cat getCat(@PathVariable(value="id") Long id) {
        return catService.findByID(id);
    }

    @RequestMapping(value = "/getAllCats", method = RequestMethod.GET)
    public List<Cat> getAllCats() {
        return catService.getAll();
    }

    @RequestMapping(value = "/deleteAllCats", method = RequestMethod.GET)
    public String deleteAllCats() {
        catService.deleteAll();
        return "Ok";
    }

    @RequestMapping(value = "/upgradeCat", method = RequestMethod.POST)
    public String upgradeCat(@RequestBody Cat cat) {
        try {
            catService.update(cat);
            return "Ok";
        } catch (Exception e) {
            return "Не удалось сохранить";
        }
    }
}
