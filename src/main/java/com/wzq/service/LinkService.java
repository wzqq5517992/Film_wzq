package com.wzq.service;

import java.util.List;

import com.wzq.entity.Link;

/**
 * 友情链接Service接口
 * @author Administrator
 *
 */
public interface LinkService {
	
	/**
	 * 分页查询友情链接
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Link> list(Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
}
