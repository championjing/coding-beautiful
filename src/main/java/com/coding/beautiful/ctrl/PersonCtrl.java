package com.coding.beautiful.ctrl;

import com.coding.beautiful.entity.Person;
import com.coding.beautiful.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author : champ
 * @version V1.0
 * @Description:
 * @date 2021年08月08日 15:14
 */
@RequestMapping("person")
@RestController
public class PersonCtrl {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> list() {
        List<Person> all = personService.list();
        return all;
    }

    @GetMapping("{id}")
    public Person findOne(@PathVariable Integer id) {
        Person person = personService.findById(id);
        return person;
    }

    @PostMapping
    public Person save(@RequestBody Person person) throws Exception {
        return personService.save( person );
    }

    @PostMapping("{id}")
    public Person save(@PathVariable Integer id, @RequestBody Person person) throws Exception {
        if ( !id.equals( person.getId() ) ) {
            throw new Exception("参数异常");
        }
        return personService.save( person );
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete( id );
    }
}
