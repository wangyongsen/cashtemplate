package com.yinghuo.share.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinghuo.core.common.log.digest.DigestLogAnnotated;
import com.yinghuo.core.common.log.digest.ProfilerAnnotated;
import com.yinghuo.core.common.log.digest.ServiceTypeEnum;
import com.yinghuo.core.service.DbService;
import com.yinghuo.share.StudentService;
@Service("ttService")
public class StudentServiceImpl implements StudentService {
@Resource
private DbService dbService;
	@Override
	@ProfilerAnnotated
	public String testCore() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "lisi";
	}

}
