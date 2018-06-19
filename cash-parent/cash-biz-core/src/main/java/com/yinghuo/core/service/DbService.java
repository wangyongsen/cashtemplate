package com.yinghuo.core.service;

import com.yinghuo.dal.entity.StudentDO;
import com.yinghuo.vo.StudentVo;

public interface DbService {
	StudentDO selectByPrimaryKey(Long id);
	 Long insert(StudentDO entity);
	 Long update(StudentDO entity);
	 Long deleteByPrimary(Long id);
	 StudentVo getByCondition(Long age,Long card,String address);
}
