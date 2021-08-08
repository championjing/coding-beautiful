package com.coding.beautiful.service;

import com.coding.beautiful.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : champ
 * @version V1.0
 * @Description:
 * @date 2021年08月08日 15:15
 */
@Service
public class PersonService {

    private final List<Person> list = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Person p1 = new Person(1, "张三", 1, 26, "北京市下沉区朝阳小区幸福苑3号楼2单元508室");
        Person p2 = new Person(2, "李四", 1, 22, "北京市下沉区海淀小区幸福苑7号楼1单元408室");
        Person p3 = new Person(3, "丸子", 2, 25, "北京市下沉区昌平小区幸福苑8号楼2单元908室");
        Person p4 = new Person(4, "饺子", 2, 28, "北京市上浮区平顶小区幸福苑9号楼2单元1208室");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
    }

    public Person findById(Integer id) {
        return list.stream().filter(person -> person.getId().equals(id)).findFirst().get();
    }

    public List<Person> list() {
        return this.list;
    }

    public List<Person> listByGenger(Integer gender) {
        return list.stream().filter(person -> person.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Person save(Person person) throws Exception {
        if (person.getId() == null) {
            List<Person> collect = list.stream().sorted(Comparator.comparing(Person::getId).reversed()).collect(Collectors.toList());
            Person lastperson = collect.get(0);
            person.setId(lastperson.getId() + 1);
            list.add(person);
        } else {
            Person temp = list.stream().filter(p -> person.getId().equals(p.getId())).findFirst().get();
            if (temp != null) {
                list.remove(temp);
                list.add(person);
            } else {
                throw new Exception("id错误");
            }
        }
        return person;
    }

    public void delete(Integer id) {
        Person temp = list.stream().filter(p -> id.equals(p.getId())).findFirst().get();
        list.remove(temp);
    }
}
