package com.packtpub.mongo.chapter3.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.DBObject;

public class SimplePojo implements DBObject {
    private Map<String, Object> data;
    private boolean partial;

    public SimplePojo() {
        data = new HashMap<>();
        partial = false;
    }

    @Override
    public Object put(String key, Object value) {
        return data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(BSONObject o) {
        data.putAll(o.toMap());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void putAll(Map m) {
        data.putAll(m);
    }

    @Override
    public Object get(String key) {
        return data.get(key);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Map toMap() {
        return data;
    }

    @Override
    public Object removeField(String key) {
        return data.remove(key);
    }

    @Override
    public boolean containsKey(String key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsField(String key) {
        return data.containsKey(key);
    }

    @Override
    public Set<String> keySet() {
        return data.keySet();
    }

    @Override
    public void markAsPartialObject() {
        partial = true;
    }

    @Override
    public boolean isPartialObject() {
        return partial;
    }
}