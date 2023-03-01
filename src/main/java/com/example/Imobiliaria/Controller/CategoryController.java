package com.example.Imobiliaria.Controller;

import com.example.Imobiliaria.Model.Category;
import com.example.Imobiliaria.Service.CategoryService;
import com.example.Imobiliaria.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CategoryController extends CrudController<Category, UUID> {
    @Autowired
    private CategoryService categoryService;
    @Override
    protected CrudService<Category, UUID> getService() {
        return categoryService;
    }
}
