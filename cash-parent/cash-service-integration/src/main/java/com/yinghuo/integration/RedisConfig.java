package com.yinghuo.integration;

public class RedisConfig {
	private String redisIp;
	private String redisPort;
	private String psw;
//    @PostConstruct
//    public void test()
//    {
//    	System.out.println("执行RedisConfig。。。。。。");
//    }
	public String getRedisIp() {
		return redisIp;
	}

	public void setRedisIp(String redisIp) {
		this.redisIp = redisIp;
	}

	public String getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(String redisPort) {
		this.redisPort = redisPort;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
