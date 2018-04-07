package com.ssm.crm.dao;

import com.ssm.crm.pojo.BaseDict;

import java.util.List;

public interface DictMapper {
	
	public List<BaseDict> findDictByCode(String code);
	
}
