package com.viepovsky.catalog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CatalogRepository extends MongoRepository<Product, String> {

}
