package com.packtpub.mongo.chapter3.pojo;

import com.mongodb.BasicDBObject;

public class SimplePojo2 extends BasicDBObject {
    public String getUpperCaseKey(String key) {
        String value = (String) super.get(key);
        if (value != null) { return value.toUpperCase(); } else { return null; }
    }
}