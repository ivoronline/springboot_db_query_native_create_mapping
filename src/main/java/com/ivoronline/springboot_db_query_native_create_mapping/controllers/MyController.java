package com.ivoronline.springboot_db_query_native_create_mapping.controllers;

import com.ivoronline.springboot_db_query_native_create_mapping.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // SELECT PERSON
  //================================================================
  @RequestMapping("SelectPerson")
  Person selectPerson() {

    //CREATE QUERY
    String select = "SELECT id, name AS authorName, age AS authorAge FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select, "PersonMapping");
           query.setParameter("name", "John");

    //SELECT PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;
  }

}


