package com.wzq.service;

import com.wzq.entity.Film;

/**
 * 电影service接口
 * @author Jolin
 *
 */
public interface FilmService {

	/**
	 * 添加或修改电影
	 * @param film
	 */
	public  void save(Film film);
}
