package com.example.servingwebcontent.controller.API;

import com.example.servingwebcontent.Repos.CategoryRepo;
import com.example.servingwebcontent.domain.Category;
import com.example.servingwebcontent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "category", produces = {"application/json"})
@ResponseBody
public class CategoryAPI {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryService categoryService;


    @GetMapping(produces = {"application/json"})
    public List<Category> list(){
        return categoryRepo.findAll();
    }


    @GetMapping("{id}")
    public Category getOne(@PathVariable Long id){
    Category one = categoryRepo.findById(id).get();
    return one; }


    @PostMapping
    public List<Category> create(@RequestBody Map<String,String> category){
    Category create=new Category();
    create.setName(category.get("name"));
    create.setId(Long.valueOf(category.get("id")));
    categoryRepo.save(create);
    return categoryRepo.findAll(); }

    @PutMapping("{id}")
    public List<Category> update(@PathVariable Long id,@RequestBody Map<String,String> category) {
    Category categoryFromDb = categoryRepo.findById(id).get();
    categoryFromDb.setName(category.get("name"));
    categoryRepo.save(categoryFromDb);
    return categoryRepo.findAll();
}


@DeleteMapping("{id}")
public String delete(@PathVariable Long id){
        categoryRepo.deleteById(id);
    return "redirect:/category";
    }

}
