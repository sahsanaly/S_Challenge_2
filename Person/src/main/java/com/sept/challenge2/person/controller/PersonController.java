package com.sept.challenge2.person.controller;

import com.sept.challenge2.person.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class PersonController {

    PersonService personService;

    
}
