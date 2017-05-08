package com.packtpub.mongo.chapter3;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.packtpub.mongo.chapter3.pojo.SimplePojo;
import com.packtpub.mongo.chapter3.pojo.SimplePojo2;

public class MyTest {

    MongoClient mongoClient;
    DB db;
    DBCollection coll;

    @Before
    public void init() {
        try {
            mongoClient = new MongoClient(new ServerAddress("10.110.25.199", 27017));
            db = mongoClient.getDB("sampledb" );
            coll = db.getCollection("pojo");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Test
    public void insertPojo() {
        SimplePojo obj = new SimplePojo();
        obj.put("user", "user1");
        obj.put("message", "message");
        obj.put("date", new Date());
        coll.insert(obj);
    }

    @Test
    public void getPojo(){
        coll.setObjectClass(SimplePojo.class);
        SimplePojo tw = (SimplePojo)coll.findOne();
        System.out.println(tw.get("user"));
    }

    @Test
    public void insertPojo2() {
        SimplePojo2 pojo = new SimplePojo2();
        pojo.put("user", "user2");
        pojo.put("message", "msg");
        pojo.put("date", new Date());
        coll.insert(pojo);
    }
}