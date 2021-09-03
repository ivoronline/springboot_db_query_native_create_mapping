package com.ivoronline.springboot_db_query_native_create_mapping.entities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
  name     = "PersonMapping",
  entities = @EntityResult(
    entityClass = Person.class,
    fields      = {
        @FieldResult(name = "id"  , column = "id"        ), //All Columns must be mapped
        @FieldResult(name = "name", column = "authorName"),
        @FieldResult(name = "age" , column = "authorAge" )
    }
  )
)
@Entity
public class Person {

  //PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

}
