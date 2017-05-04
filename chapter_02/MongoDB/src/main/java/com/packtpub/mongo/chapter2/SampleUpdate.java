package com.packtpub.mongo.chapter2;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class SampleUpdate {
    private final static int PORT = 27017;
    private final static String HOST = "10.110.25.199";

    public static void main(String args[]) {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            /*DBObject newDocument = new BasicDBObject();
            newDocument.put("age", 23);*/
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("age", 23));
            DBObject searchQuery = new BasicDBObject().append("name", "owen");
            coll.update(searchQuery, newDocument);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
