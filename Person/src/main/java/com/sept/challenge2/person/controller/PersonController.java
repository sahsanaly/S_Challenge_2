package com.sept.challenge2.person.controller;

import com.sept.challenge2.person.model.Person;
import com.sept.challenge2.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(path = "/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createPerson(@RequestBody Person person)
            throws Exception {
        Person createdPerson = personService.createPerson(person);
        if (createdPerson == null){
            return new ResponseEntity<>("Person already created!", HttpStatus.OK);
        }
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping(path="/person/person{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getPersonById(@PathVariable("id") Integer id)
            throws Exception {
        Optional person = personService.getPersonById(id);
        if (!person.isPresent()) {
            return  new ResponseEntity<>("Could not find the person for the provided id", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @GetMapping(path="/persons/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getAllPersons()
            throws Exception {
        List<Person> allPersons = personService.getAllPersons();
        if (allPersons.size() > 0) {
            return  new ResponseEntity<>(allPersons, HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("No person found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path="/persons/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deletePerson(@RequestBody Person person)
            throws Exception {
        Person deletedPerson = personService.deletePerson(person);
        if (deletedPerson == null){
            return new ResponseEntity<>("No person exists or enter a valid id number!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Person deleted!", HttpStatus.CREATED);
    }

    @PutMapping(path = "/persons/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person)
            throws Exception {
        Person updatedPerson = personService.updatePerson(person);
        if (updatedPerson == null){
            return new ResponseEntity<>("Nothing to update!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Person updated!", HttpStatus.CREATED);
    }


}
