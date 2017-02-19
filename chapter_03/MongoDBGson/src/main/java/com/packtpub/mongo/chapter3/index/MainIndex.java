/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.index;

import com.mongodb.*;


public class MainIndex {

    public static void main(String args[]) {
        try {

            MongoClient mongoClient = new MongoClient(new ServerAddress("200.200.200.204", 49161) );

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("indextest");
            coll.createIndex(new BasicDBObject("userid", 1));
            for (int ii = 0; ii < 10000; ii++) {

                BasicDBObject doc = new BasicDBObject("userid", ii);

                coll.insert(doc);

            }
            BasicDBObject doc = new BasicDBObject("userid", "1111");
            DBObject explainObject = coll.find(doc).explain();

            System.out.println(explainObject);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
