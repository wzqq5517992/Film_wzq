package com.wzq.reponsitory;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wzq.entity.Film;
import com.wzq.entity.Link;

/**
 * 友情链接repository 接口
 * @author Jolin
 *
 */
public interface LinkRepository   extends JpaRepository<Link, Integer>{

}
