/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {
    //private  String user="ude"; // the user name
    private  String database="ude"; // the name of the database in which the user is defined
    //private char[] password="ude".toCharArray(); // the password as a character array
    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public Mongo mongo() throws Exception {

        // ...
        /*MongoCredential credential = MongoCredential.createScramSha1Credential(user,
                database,
                password);*/
        /*MongoClient mongoClient = new MongoClient(new ServerAddress("10.110.25.199", 27017),
                Arrays.asList(credential));*/
        MongoClient mongoClient = new MongoClient(new ServerAddress("10.110.25.199", 27017));
        return mongoClient;
    }
    @Override
    protected String getMappingBasePackage() {
        return "com.packtpub.mongo.chapter6.repository";
    }
}
