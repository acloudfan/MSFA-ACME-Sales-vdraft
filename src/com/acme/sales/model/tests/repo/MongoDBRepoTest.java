package com.acme.sales.model.tests.repo;

import com.acme.infra.mongodb.MongoDBBase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

/**
 * Tests the MongoDBBase class
 */
public class MongoDBRepoTest extends MongoDBBase  {

    /**
     * Main test function
     */
    public static void main(String[] args){

        // 1. Create an instance of the MongoDBTest
        MongoDBRepoTest mongoDBRepoTest = new MongoDBRepoTest();

        // 2. Create the document to be inserted in "test" collection
        String json = "{ 'name': 'john', 'age': 32}";

        // 3. Execute the insert to add document to collection
        mongoDBRepoTest.executeInsert("test", json);
        System.out.println("1. Inserted into collection");

        // 4. Execute the function to get by name
        json = mongoDBRepoTest.getByName("john");

        // 5. Print the received document
        System.out.println("2. Retrieved into collection");
        System.out.println("JSON="+json);

    }

    /**
     * Gets the document from test collection by 'name'
     * @return
     */
    public String getByName(String name){

        String json ="{count: 0}";

        // 1. Create the filter
        Bson bson =  Filters.eq("name",name);

        // 2. Execute find
        FindIterable iterable = find("test", bson);


        // 3. Convert the documents to JSON string and return
        ArrayList<Document> docs = new ArrayList<Document>();

        iterable.into(docs);

        if(docs.size() == 0){
            return json;
        }

        json = "{ count: 1, result: "+docs.get(0).toJson() +"}";

        return json;
    }
}
