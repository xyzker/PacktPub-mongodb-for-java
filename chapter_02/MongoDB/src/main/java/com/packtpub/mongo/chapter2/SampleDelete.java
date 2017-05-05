package com.packtpub.mongo.chapter2;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class SampleDelete {
    private final static int PORT = 27017;
    private final static String HOST = "10.110.25.199";

    public static void main(String args[]) {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            //DBObject doc = coll.findOne();

            /*DBObject document = new BasicDBObject();
            document.put("name", "frank");
            coll.remove(document);*/

            BasicDBObject deleteQuery = new BasicDBObject();
            List<Integer> list = new ArrayList<Integer>();
            for (int i=0;i<50;i++)
                list.add(i);
            deleteQuery.put("age", new BasicDBObject("$in", list));
            coll.remove(deleteQuery);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
