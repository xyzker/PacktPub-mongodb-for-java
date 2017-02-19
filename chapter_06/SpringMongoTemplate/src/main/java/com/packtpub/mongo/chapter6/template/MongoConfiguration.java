/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.template;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "ude";
    }

    @Override
    public Mongo mongo() throws Exception {
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
    }
 
}
