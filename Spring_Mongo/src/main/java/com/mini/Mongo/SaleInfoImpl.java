package com.mini.Mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SaleInfoImpl implements SaleInfoDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	String Collation_Name="data_collection";
	
	List<SaleInfoDTO> InfoList = new ArrayList<SaleInfoDTO>();
	
	
	@Override
	public List<SaleInfoDTO> getAll() {
		InfoList = mongoTemplate.findAll(SaleInfoDTO.class, Collation_Name);
		return InfoList;
	}
	
	@Override
	public List<SaleInfoDTO> findone(String key, String value) {
		Criteria criteria =new Criteria(key);
		criteria.is(value);
		
		Query query = new Query(criteria);
		InfoList = mongoTemplate.find(query, SaleInfoDTO.class, Collation_Name);

		return InfoList;
	}
	
}
