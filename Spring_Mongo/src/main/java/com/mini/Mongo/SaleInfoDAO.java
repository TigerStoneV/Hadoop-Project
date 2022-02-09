package com.mini.Mongo;

import java.util.List;

public interface SaleInfoDAO {
	List<SaleInfoDTO> getAll();
	List<SaleInfoDTO> findone(String key, String value);
}
