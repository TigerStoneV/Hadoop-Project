package com.mini.Mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class SaleInfoServiceImpl implements SaleInfoService {

	@Autowired
	private SaleInfoDAO saleinfoDao;
	
	@Override
	public List<SaleInfoDTO> getAll() {
		return saleinfoDao.getAll();
	}
	
	@Override
	public List<SaleInfoDTO> findone(String key, String value) {
		return saleinfoDao.findone(key, value);
	}
}
