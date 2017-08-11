package com.tiagodeluna.insurance.persistence;

import java.util.List;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.tiagodeluna.insurance.domain.Insurance;

@Component
public class InsuranceRepositoryImpl implements InsuranceRepository {

	@Value("${mongodb.uri:test}")
	private String connectionString;
	@Value("${mongodb.database:test}")
	private String dbName;
	@Value("${mongodb.collection:test}")
	private String collectionName;

	private MongoClient mongoClient = null;
	
	public InsuranceRepositoryImpl() {
		super();
	}

	private DBCollection getCollection() {
		MongoClientURI uri = new MongoClientURI(connectionString);

		mongoClient = new MongoClient(uri);
		DB db = mongoClient.getDB(dbName);
		DBCollection dbCollection = db.getCollection(collectionName);

		return dbCollection;
	}

	@Override
	public void save(Insurance insurance) {
		System.out.println("*** MongoDB Insert ***");
		DBCollection dbCollection = getCollection();

		JacksonDBCollection<Insurance, String> coll = JacksonDBCollection.wrap(dbCollection, Insurance.class,
				String.class);
		WriteResult<Insurance, String> result = coll.insert(insurance);
		
		mongoClient.close();
	}

	@Override
	public List<Insurance> findAll() {
		System.out.println("*** MongoDB Find ***");
		DBCollection dbCollection = getCollection();
		
		  JacksonDBCollection<Insurance, String> coll = JacksonDBCollection.wrap(dbCollection, Insurance.class,
		          String.class);
		  List<Insurance> insurances = coll.find().toArray();
		  
		  mongoClient.close();
		  
		  return insurances;
	}

	@Override
	public void drop() {
		System.out.println("*** MongoDB Drop ***");
		DBCollection dbCollection = getCollection();
		
		  JacksonDBCollection<Insurance, String> coll = JacksonDBCollection.wrap(dbCollection, Insurance.class,
		          String.class);
		  coll.drop();
		  mongoClient.close();
	}

}
