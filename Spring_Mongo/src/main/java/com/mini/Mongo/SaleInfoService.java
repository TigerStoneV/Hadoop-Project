package com.mini.Mongo;

import java.util.HashMap;
import java.util.List;

public interface SaleInfoService {
	List<SaleInfoDTO> getAll();
	List<SaleInfoDTO> findone(String key, String value);
}
