/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter2;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertMongo {
	public static void main(String args[]) {
		try {

			MongoClient mongoClient = new MongoClient(new ServerAddress("10.110.25.199", 27017));
			 
			MongoDatabase db = mongoClient.getDatabase("sampledb");
			MongoCollection<Document> coll = db.getCollection("users");

			//Document doc = new Document("name", "john").append("age", 25).append("phone", "321-654-987");
			/*Document doc = new Document("name", "louis").append("age", 29)
														.append("info",
																new Document("email", "louis@mail.com").append(
																		"phone", "876-134-667"));
			coll.insertOne(doc);

			List<Document> documents = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				documents.add(new Document("key", UUID.randomUUID().toString()));
			}
			coll.insertMany(documents);*/
			/*MongoIterable<String> collections = db.listCollectionNames();
			MongoCursor<String> cursor = collections.iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}*/

			MongoCursor<Document> cursor = coll.find().iterator();
			try {
				while (cursor.hasNext()) {
					Document document = cursor.next();
					System.out.println(document.toJson());
				}
			} finally {
				cursor.close();
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}