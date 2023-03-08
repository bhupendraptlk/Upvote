package com.upvote.vote.Service;

import com.upvote.vote.Entity.Dish;
import com.upvote.vote.Repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepository;

    public List<Dish> getDishes(){
        return dishRepository.findAll();
    }

    public List<Dish> getDishByName(String name){
        List<Dish> searched = dishRepository.findAll().stream().filter(ele->ele.getName().toLowerCase().startsWith(name.toLowerCase())).toList();
        return searched;
    }
    public Dish getDishById(Integer id){
        return dishRepository.findDishById(id);
    }
    public Integer updateCounterById(String task,Integer id){
        Dish dish = dishRepository.findDishById(id);
        Integer val = dish.getCount();
        if(task.equals("upvote")){
            val+=1;
        }
        else if(val!=0){
            val--;
        }
        dish.setCount(val);
        dishRepository.save(dish);
        return val;
    }
    public Integer getCounterById(Integer id){
        return getDishById(id).getCount();
    }
    public Dish addNewDish(Dish dish){
        return dishRepository.save(dish);
    }
    public void updateDishById(Integer id, Dish dish){
        dish.setId(id);
        dishRepository.save(dish);
    }
    public void deleteDishById(Integer id){
        dishRepository.deleteById(id);
    }
}
