package com.cats.spring.service;

import com.cats.spring.model.Cat;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface CatService {
    void add(Cat cat);
    void update(Cat cat);
    List<Cat> getAll();
    List<Cat> getAllPageable(Pageable pageable);
    Cat findByID(Long id);
    void deleteByID(Long id);
    void deleteAll();
}
