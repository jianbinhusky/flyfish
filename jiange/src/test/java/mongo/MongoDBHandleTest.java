package mongo;

import com.hujianbin.manage.bean.Account;
import com.hujianbin.manage.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by hujb4 on 2016/5/20.
 */

public class MongoDBHandleTest {
    private MongoOperations mongoOperations;

    @Before
    public void testBefore(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Test
    public void testInsert(){
        Person p = new Person();
        p.setAge(22);
        p.setName("Kassne");
        p.getAccounts().add(new Account("1234-343-3321",Account.Type.SAVINGS,123.45));

        mongoOperations.insert(p);

        System.out.println("Done!");

    }

    @Test
    public void testCollectExists(){
        if(mongoOperations.collectionExists(Person.class)){
            System.out.println("exists");
        }
        if(!mongoOperations.collectionExists(Account.class)){
            System.out.println("not exists");
            mongoOperations.createCollection(Account.class);
        }
        if(mongoOperations.collectionExists("person")){
            System.out.println("exists");
        }
    }

    @Test
    public void testFindById(){
        Person p = mongoOperations.findById("573ed03edad9ae3f862cda00", Person.class);
        System.out.println(p.getName());
    }
}
