package com.innoxitsolution.spingbootproject.repository;

import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long>
{

}

