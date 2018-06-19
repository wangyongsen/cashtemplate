package com.yinghuo.control;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yinghuo.component.distributed.file.FastDfsClient;
import com.yinghuo.component.distributed.jms.MqProducer;
import com.yinghuo.component.distributed.redis.RedisCacheClient;
import com.yinghuo.component.extend.DynamicKeyUtil;
import com.yinghuo.core.service.DbService;
import com.yinghuo.vo.StudentVo;

@RestController
@RequestMapping("demo")
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	@Resource
	private DbService dbService;
	@Resource
	private MqProducer mqProducer;
	@Resource
	private RedisCacheClient redisCacheClient;
	@Resource
	private FastDfsClient fastDfsClient;
	@RequestMapping(value = "/testModel", method = { RequestMethod.GET })
	@ResponseBody
	public String testModel(@Valid User user, BindingResult bindingResult, HttpServletRequest req,
			HttpServletResponse rep) {
		if (bindingResult.hasErrors()) {

			String msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return msg;
		}
		
		return "success";
	}

	@RequestMapping(value = "/testDb", method = { RequestMethod.GET })
	@ResponseBody
	public String testDb(HttpServletRequest req, HttpServletResponse rep) {
		Arrays.asList("111","222",333).forEach(x->System.out.println(x));
		StudentVo vo = dbService.getByCondition(23l, 111l, "浙江杭州!!");
		System.out.println(vo.getAddress());
		return vo.getAddress();
	}

	@RequestMapping(value = "/testFile", method = { RequestMethod.GET })
	@ResponseBody
	public String testFile(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		File file = new File("/Users/peizilong/Documents/2.jpeg");
		Map<String, String> metaList = new HashMap<String, String>();
		metaList.put("width", "1024");
		metaList.put("height", "768");
		metaList.put("author", "测试图片");
		metaList.put("date", "20161018");
		String fid = fastDfsClient.uploadByFile(file, file.getName(), metaList);
		System.out.println("upload local file1 " + file.getPath() + " ok, fileid1=" + fid);
		return "测试dfs图片上传地址:" + fastDfsClient.assembleImageUrl(fid);
	}

	@RequestMapping(value = "/testMq", method = { RequestMethod.GET })
	@ResponseBody
	public void testMq(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		for (int i = 0; i < 5000; i++) {
			boolean result = mqProducer.sendOrder("topic_ying_xin_xin", String.valueOf("测试:" + i), 1111);
			System.out.println("发送状态：第"+i+"条");
		}
	}

	@RequestMapping(value = "/testRedis", method = { RequestMethod.GET })
	@ResponseBody
	public String testRedis(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		System.out.println("classname:"+DynamicKeyUtil.getValue("test.yinghuo"));
		String result = redisCacheClient.set("ggs", "迎风而起!");
		return "测试REDIS返回:" + result;
	}
}
