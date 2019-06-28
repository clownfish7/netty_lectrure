package com.yzy.thrift;

import com.yzy.thrift.gen.Person;
import com.yzy.thrift.gen.PersonService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author yzy
 * @classname ThriftClient
 * @description TODO
 * @create 2019-06-28 14:15
 */
public class ThriftClient {
    public static void main(String[] args) throws Exception {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol tProtocol = new TCompactProtocol(tTransport);

        PersonService.Client client = new PersonService.Client(tProtocol);

        try {
            tTransport.open();
            Person p = client.getPersonByUsername("张三");
            System.out.println("getPersonByUsername: " + p);
            System.out.println(p.getAge());
            System.out.println(p.isMarried());

            Person person = new Person();
            person.setUsername("yzy");
            person.setAge(18);
            person.setMarried(false);
            client.savePerson(person);
            System.out.println("savePerson!");

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            tTransport.close();
        }
    }
}
