package com.wzq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzq.entity.Film;
import com.wzq.reponsitory.FilmRepository;
import com.wzq.service.FilmService;

/**
 * 电影service实现类
 * @author Jolin
 *
 */
@Service("filmService")
public class FilmServiceImpl  implements FilmService{
	@Resource
	private FilmRepository  filmRepository;
	@Override
	public void save(Film film) {
		filmRepository.save(film);
		
		
	}

}
