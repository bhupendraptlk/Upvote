package com.upvote.vote.Repository;

import com.upvote.vote.Entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DishRepository extends JpaRepository<Dish,Integer> {
    Dish findDishById(Integer id);
}
