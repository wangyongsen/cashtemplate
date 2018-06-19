package com.yinghuo.integration;

import com.yinghuo.component.distributed.job.DealMessageInteface;

public class MqCustomDeal implements DealMessageInteface {

	@Override
	public Boolean dealMsg(String msg) {
		//TODO  业务处理代码
		System.out.println("接受结果:"+msg);
		return true;
	}
}
