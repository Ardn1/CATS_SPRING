package com.cats.spring.service;

import com.cats.spring.model.Cat;
import com.cats.spring.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImp implements CatService {
    //@Autowired
    private final CatRepository catRepository;

    @Override
    public void add(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public void update(Cat cat) {
        Cat oldCat = catRepository.findById(cat.getID()).orElseThrow();
        oldCat.setCat(cat);
        catRepository.save(oldCat);
    }

    @Override
    public List<Cat> getAllPageable(Pageable pageable) {
        return catRepository.findAll(pageable);
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }


    @Override
    public Cat findByID(Long id) {
        return catRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteByID(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        catRepository.deleteAll();
    }

}
