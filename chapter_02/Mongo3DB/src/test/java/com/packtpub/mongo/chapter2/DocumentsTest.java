package com.packtpub.mongo.chapter2;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lte;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class DocumentsTest {

    MongoClient mongoClient;
    MongoDatabase db;

    @Before
    public void init(){
        try {
            mongoClient = new MongoClient(new ServerAddress("10.110.25.199", 27017));
            db = mongoClient.getDatabase("sampledb");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    @Test
    public void filter(){
        MongoCollection<Document> coll = db.getCollection("users");

       /* MongoCursor<Document> cursor = coll.find(eq("name",
                                                    "john")).iterator();*/

        MongoCursor<Document> cursor = coll.find(and(gt("age", 20),
                                                           lte("age", 40))).iterator();
        Document myDoc = coll.find(eq("name", "john")).first();
        System.out.println(myDoc.toJson());
/*        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }
        } finally {
            cursor.close();
        }*/
    }

    @Test
    public void update(){
        MongoCollection<org.bson.Document> coll =
                db.getCollection("users");
        /*coll.updateOne(eq("name", "john"), new Document("$set", new
                Document("age", 50)));*/
        UpdateResult updateResult = coll.updateMany(eq("name", "john"),
                                                    new Document("$set", new Document("age", 50)));
        System.out.println(updateResult.getModifiedCount());
    }

    @Test
    public void delete(){
        MongoCollection<org.bson.Document> coll =
                db.getCollection("users");
        //coll.deleteOne(eq("name", "john"));
        DeleteResult deleteResult = coll.deleteMany(eq("name", "john"));
        System.out.println(deleteResult.getDeletedCount());
    }
}
