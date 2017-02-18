package com.packtpub.mongo.chapter4.producer;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
 
import javax.enterprise.inject.Produces;
@ApplicationScoped
public class Producer {
        private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());
	  @Produces
	  public MongoClient mongoClient() {
	    try {
	    	String user="ude"; // the user name
	        String database="ude"; // the name of the database in which the user is defined
	        char[] password="ude".toCharArray(); // the password as a character array
	        // ...
	        MongoCredential credential = MongoCredential.createScramSha1Credential(user,
	                                                                              database,
	                                                                              password);
	        MongoClient mongoClient = new MongoClient(new ServerAddress("200.200.200.204", 49161),
	                                                     Arrays.asList(credential));
			return mongoClient;
		} catch ( Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	    return null;
	  }
}
