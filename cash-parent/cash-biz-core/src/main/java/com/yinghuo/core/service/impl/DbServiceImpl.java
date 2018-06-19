package com.yinghuo.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinghuo.core.common.log.digest.ProfilerAnnotated;
import com.yinghuo.core.common.service.template.ServiceTemplate;
import com.yinghuo.core.service.DbService;
import com.yinghuo.dal.dao.StudentDOMapper;
import com.yinghuo.dal.entity.StudentDO;
import com.yinghuo.vo.StudentVo;
@Service("dbService")
public class DbServiceImpl implements DbService {
@Resource
private StudentDOMapper studentDOMapper;
@Resource
private ServiceTemplate serviceTemplate;
@Override
@ProfilerAnnotated
public StudentDO selectByPrimaryKey(Long id) {
	return null;
}

@Override
public Long update(StudentDO entity) {
	// TODO Auto-generated method stub
	return studentDOMapper.update(entity);
}


@Override
public StudentVo getByCondition(Long age,Long card,String address) {
	// TODO Auto-generated method stub
	return studentDOMapper.getUnionTableByCondition(age,card,address);
}

@Override
public Long insert(StudentDO entity) {
	// TODO Auto-generated method stub
	return studentDOMapper.insert(entity);
}

@Override
public Long deleteByPrimary(Long id) {
	// TODO Auto-generated method stub
	return studentDOMapper.deleteByPrimary(id);
}
}
