package com.sept.challenge2.person.service;

import com.sept.challenge2.person.dao.PersonDao;
import com.sept.challenge2.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public Person createPerson(Person person) {
        List<Person> numOfPersons = personDao.findAll();
        System.out.println("before loop, num of persons:" + numOfPersons.size());

        if (numOfPersons.size()>0){
            for (int i=0; i<numOfPersons.size();i++) {
                if (i == numOfPersons.size() - 1) {
                    person.setId(numOfPersons.get(i).getId() + 1);
                    return personDao.save(person);
                }
            }
        }else{
            person.setId(1);
            return personDao.save(person);
        }
        return null;
    }

    public Optional getPersonById(Integer id) throws NoSuchElementException {
        try {
            return personDao.findById(id);
        } catch (Exception e) {
            throw new NoSuchElementException("Person id not found");
        }
    }

    public List<Person> getAllPersons(){
        List<Person> allPersons = personDao.findAll();
        return allPersons;
    }

    public Person updatePerson(Person person) {
        List<Person> allPersons = personDao.findAll();
        for (int i=0; i<allPersons.size();i++){
            if (allPersons.get(i).getId()==person.getId()){
                allPersons.get(i).setAddress(person.getAddress());
                allPersons.get(i).setAge(person.getAge());
                allPersons.get(i).setEmail(person.getEmail());
                allPersons.get(i).setJob(person.getJob());
                allPersons.get(i).setPhoneNumber(person.getPhoneNumber());
                allPersons.get(i).setPostcode(person.getPostcode());

                personDao.save(allPersons.get(i));
                return allPersons.get(i);
            }
        }
        return null;
    }

    public Person deletePerson(Person person){
        List<Person> allPersons = personDao.findAll();
        for (int i=0; i<allPersons.size();i++){
            if (allPersons.get(i).getId()==person.getId()) {
                personDao.delete(allPersons.get(i));
                return allPersons.get(i);
            }
        }
        return null;
    }
}
