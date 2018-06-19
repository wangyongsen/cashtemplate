package com.yinghuo.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.yinghuo.core.service.DbService;

public class DemoTest extends BaseTest {
	@Resource
	private DbService dbService;

	@Test
	public void say() {
		System.out.println(dbService.getByCondition(23l, 111l, "浙江杭州").getAddress());
	}
}
