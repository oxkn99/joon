package com.hyeok.joon.service;

import java.util.List;
import com.hyeok.joon.vo.HomeWork;
import com.hyeok.joon.vo.NewsVO;

public interface NewsServiceImpl {
	public List<NewsVO> getNews();
	public List<HomeWork>getHomeWorkList();
}
