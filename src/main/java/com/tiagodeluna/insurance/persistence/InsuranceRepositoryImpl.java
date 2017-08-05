package com.tiagodeluna.insurance.persistence;

import java.util.List;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.tiagodeluna.insurance.domain.Insurance;

public class InsuranceRepositoryImpl implements InsuranceRepository {

	private MongoClient mongoClient = null;

	public InsuranceRepositoryImpl() {
		super();
	}

	private DBCollection getCollection() {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://tiagodeluna:xWEVaVcE6o1IKZi5@lunacluster01-shard-00-00-rkwgc.mongodb.net:27017,lunacluster01-shard-00-01-rkwgc.mongodb.net:27017,lunacluster01-shard-00-02-rkwgc.mongodb.net:27017/root?ssl=true&replicaSet=LunaCluster01-shard-0&authSource=admin");

		mongoClient = new MongoClient(uri);
		DB db = mongoClient.getDB( "insurancesDB" );
		DBCollection dbCollection = db.getCollection("insurances");

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
