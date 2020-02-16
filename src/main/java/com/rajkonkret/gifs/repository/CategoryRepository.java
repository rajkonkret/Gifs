package com.rajkonkret.gifs.repository;

import com.rajkonkret.gifs.model.Category;
import org.springframework.stereotype.Repository;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES =  Arrays.asList(
            new Category(0, "funny"),
            new Category(1, "sport"),
            new Category(2, "it")
    );

    public List<Category> getAllCategory() {
        return ALL_CATEGORIES;
    }

    public Category getCategoryById(int id){
        return ALL_CATEGORIES.stream()
                .filter(s -> s.getId() == id )
                .findAny().get();
    }

}
