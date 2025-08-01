package com.innoxitsolution.spingbootproject.repository;



import com.innoxitsolution.spingbootproject.model.Mongo.EmployeeInfoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<EmployeeInfoMongo, String> {
}
