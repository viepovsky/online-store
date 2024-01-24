package com.viepovsky.basket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BasketRepository extends CrudRepository<Basket, String> {

}
