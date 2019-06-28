package com.yzy.thrift;

import com.yzy.thrift.gen.DataException;
import com.yzy.thrift.gen.Person;
import com.yzy.thrift.gen.PersonService;
import org.apache.thrift.TException;

/**
 * @author yzy
 * @classname PersonServiceImpl
 * @description TODO
 * @create 2019-06-28 14:01
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("got client param: " + username);

        Person person = new Person();
        person.setAge(18);
        person.setUsername("余志友");
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("got client param: " + person);
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
