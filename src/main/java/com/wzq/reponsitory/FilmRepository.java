package com.wzq.reponsitory;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wzq.entity.Film;

/**
 * 电影repository 接口
 * @author Jolin
 *
 */
public interface FilmRepository   extends JpaRepository<Film, Integer>{

}
