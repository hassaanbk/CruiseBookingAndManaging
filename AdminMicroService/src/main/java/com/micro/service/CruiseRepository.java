package com.micro.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CruiseRepository extends ReactiveMongoRepository<Cruise, Integer>{

}
