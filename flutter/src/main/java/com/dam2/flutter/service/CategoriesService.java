package com.dam2.flutter.service;

import java.util.List;
import com.dam2.flutter.entity.Categories;

public interface CategoriesService {

    List<Categories> findAll();
    Categories findById(Long id);
    Categories save(Categories categories);
    void deleteById(Long id);

}


