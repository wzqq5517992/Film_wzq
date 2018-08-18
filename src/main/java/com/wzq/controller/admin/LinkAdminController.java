package com.wzq.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzq.entity.Link;
import com.wzq.service.LinkService;



/**
 * 友情链接Controller类
 * @author Jolin
 *
 */
@RestController
@RequestMapping("/admin/link")
public class LinkAdminController {
	
	@Resource
	private LinkService  linkService;
	@RequestMapping("list")
	public Map<String,Object> list(@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<Link> linkList=linkService.list(page-1, rows);
		Long total=linkService.getCount();
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows", linkList);
		resultMap.put("total", total);
		return resultMap;
	}

	
}
