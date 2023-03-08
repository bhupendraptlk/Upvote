package com.upvote.vote.Controller;

import com.upvote.vote.Entity.Dish;
import com.upvote.vote.Service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    @Autowired
    DishService ds;

    @RequestMapping("upvote/dishes/search/")
    public List<Dish> getAllDishes(){
        return ds.getDishes();
    }

    @GetMapping("upvote/dishes/search/{name}")
    public List<Dish> getDishes(@PathVariable("name") String name){
        return ds.getDishByName(name);
    }

    @GetMapping("upvote/dishes/{id}")
    public Dish getDish(@PathVariable("id") Integer id){
        return ds.getDishById(id);
    }

    @GetMapping("upvote/dishes/count/{id}")
    public Integer getCounter(@PathVariable("id") Integer id){
        return ds.getCounterById(id);
    }

    @PutMapping("upvote/dishes/update/{task}/{id}")
    public Integer IncrementCounter(@PathVariable("task") String task, @PathVariable("id") Integer id){
        return ds.updateCounterById(task,id);
    }

    @PostMapping("upvote/dishes/add")
    public Dish addDish(@RequestBody Dish dish){
        return ds.addNewDish(dish);
    }

    @PutMapping("upvote/dishes/update/{id}")
    public void updateDish(@PathVariable("id") Integer id, @RequestBody Dish dish){
        ds.updateDishById(id,dish);
    }

    @DeleteMapping("upvote/dishes/delete/{id}")
    public void deleteDish(@PathVariable Integer id){
        ds.deleteDishById(id);
    }
}