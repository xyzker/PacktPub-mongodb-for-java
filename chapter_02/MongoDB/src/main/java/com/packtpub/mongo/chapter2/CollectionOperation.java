package com.packtpub.mongo.chapter2;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class CollectionOperation {
    private final static int PORT = 27017;
    private final static String HOST = "10.110.25.199";

    public static void main(String args[]) {
        MongoClient mongoClient = new MongoClient(HOST, PORT);

        DB db = mongoClient.getDB("sampledb");

        /*DBObject options = BasicDBObjectBuilder.start().add("capped",
                                                            true).add("size", 1000000000l).get();
        DBCollection collection =
                db.createCollection("orderedcollection", options);*/

        for (String s : db.getCollectionNames()) {
            System.out.println(s);
        }

/*        DBCollection coll = db.getCollection("testCollection");
        coll.drop();

        DBCursor c = coll.find();
        while (c.hasNext()) {
            coll.remove(c.next());
        }*/
    }
}
