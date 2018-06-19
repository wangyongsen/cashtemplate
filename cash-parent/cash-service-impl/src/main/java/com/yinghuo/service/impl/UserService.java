package com.yinghuo.service.impl;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.yinghuo.core.base.Result;
import com.yinghuo.core.common.log.digest.DigestLogAnnotated;
import com.yinghuo.core.common.log.digest.ProfilerAnnotated;
import com.yinghuo.core.common.log.digest.ServiceTypeEnum;
import com.yinghuo.core.common.service.template.ServiceCheckCallback;
import com.yinghuo.core.common.service.template.ServiceTemplate;
import com.yinghuo.core.service.DbService;
import com.yinghuo.service.facade.IUserService;

@Service(protocol = {"rest", "dubbo"})
@Path("user")
@ProfilerAnnotated(time="1")
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserService implements IUserService {
	@Resource
	private DbService dbService;
	@Resource
	private ServiceTemplate serviceTemplate;
	
	@GET
	@Path("aaa")
	@Produces(MediaType.APPLICATION_JSON)
	@ProfilerAnnotated(time="1")
	@DigestLogAnnotated(serviceType = ServiceTypeEnum.APP, bizKey = "用户余额查询",systemName="系统库")
	public Result<String> sayHello() {
		// TODO Auto-generated method stub
		Result<String> result=new Result<String>();
        return result;
	}

}
