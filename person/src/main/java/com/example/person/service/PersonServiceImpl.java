package com.example.person.service;

import com.example.person.dto.PersonDTO;
import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import com.example.person.service.interfaces.PersonService;
import com.example.person.translator.PersonTranslator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonTranslator personTranslator;

    public PersonServiceImpl(PersonRepository personRepository, PersonTranslator personTranslator) {
        this.personRepository = personRepository;
        this.personTranslator = personTranslator;
    }

    @Override
    public Long create(PersonDTO personDTO) {
        Person savedperson = personRepository.save(personTranslator.personDTOToPerson(personDTO));
        return savedperson.getId();
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        Person savedperson = personRepository.save(personTranslator.personDTOToPerson(personDTO));
        return personTranslator.personToPersonDTO(savedperson);
    }

    @Override
    public PersonDTO findById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.map(person -> personTranslator.personToPersonDTO(person)).orElse(null);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
