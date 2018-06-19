package com.yinghuo.biz.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.yinghuo.component.distributed.file.FastDfsClient;

@JobHandler(value="jjobHandler")
@Component
public class JobDemo extends IJobHandler {
	@Resource
	private FastDfsClient fastDfsClient;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		System.out.println("###定时任务执行成功测试####");
		return SUCCESS;
	}
	
}
