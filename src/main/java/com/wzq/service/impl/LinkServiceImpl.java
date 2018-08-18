package com.wzq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wzq.entity.Link;
import com.wzq.reponsitory.LinkRepository;
import com.wzq.service.FilmService;
import com.wzq.service.LinkService;

/**
 * 友情链接service实现类
 * @author Jolin
 *
 */
@Service("linkService")
public class LinkServiceImpl  implements LinkService{

	@Resource
	private LinkRepository linkRepository;
	@Override
	public List<Link> list(Integer page, Integer pageSize) {
		return linkRepository.findAll(new PageRequest(page, pageSize)).getContent();
		
	}
	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return linkRepository.count();
	}


}
