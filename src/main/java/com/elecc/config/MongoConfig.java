/**
 * 
 */
package com.elecc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author Ramón Cigüenza
 *
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "elecc";
    }
  
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("cluster0-shard-00-01-owogt.mongodb.net", 27017);
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "org.baeldung";
    }
}
