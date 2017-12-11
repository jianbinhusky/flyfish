package com.hujianbin.manage.action;

import com.hujianbin.manage.bean.Account;
import com.hujianbin.manage.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloMongo {

	@Autowired
	MongoTemplate mongoOperations;

	@RequestMapping(value="/mongo")
	public void add() {

		if (!mongoOperations.collectionExists(Person.class)) {
			mongoOperations.createCollection(Person.class);
		}

		Person p = new Person("Mike", 33);
		Account a = new Account("1234-59873-893-6", Account.Type.SAVINGS, 13.45D);
		p.getAccounts().add(a);


//		mongoOperations.insert(p);
		Query query = new Query();
		mongoOperations.find(query,Person.class);
		Person person = null;
		try {
			person = mongoOperations.findById("573d86022504085b68f82224", Person.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(person.getName());

//		List<Person> results = mongoOperations.findAll(Person.class);
//		System.out.println("Results: " + results);
	}

}
