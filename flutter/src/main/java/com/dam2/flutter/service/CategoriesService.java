package com.dam2.flutter.service;

import com.dam2.flutter.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAll();
    Categories findById(Long id);
    Categories save(Categories categories);
    void deleteById(Long id);

}


