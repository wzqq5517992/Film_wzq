package com.wzq.service;

import com.wzq.entity.Film;

/**
 * 电影Service接口
 * @author Administrator
 *
 */
public interface FilmService {
	
	/**
	 * 添加或者修改电影
	 * @param film
	 */
	public void save(Film film);
}
