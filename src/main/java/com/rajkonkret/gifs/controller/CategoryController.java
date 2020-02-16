package com.rajkonkret.gifs.controller;

import com.rajkonkret.gifs.model.Category;
import com.rajkonkret.gifs.model.Gif;
import com.rajkonkret.gifs.repository.CategoryRepository;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        List<Category> category = categoryRepository.getAllCategory();
        //System.out.println(g.get().getName());
        modelMap.put("categories", category);

        return "categories";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.getCategoryById(id);
        List<Gif> gifList = gifRepository.getGifByCategory(category);

        modelMap.put("category", category);
        modelMap.put("gifs", gifList);

        return "category";

    }
}
