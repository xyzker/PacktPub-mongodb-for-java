package com.packtpub.mongo.chapter2;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class SampleQuery {

    private final static int PORT = 27017;
    private final static String HOST = "10.110.25.199";

    public static void main(String args[]) {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            DBCursor cursor = coll.find();
            //DBObject query = new BasicDBObject("name", "owen");
            /*DBObject query = new
                    BasicDBObject("name", new BasicDBObject("$ne",
                                                            "frank")).append("age", new BasicDBObject("$gt", 10));*/
            //DBCursor cursor = coll.find(query);
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    System.out.println(object);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
