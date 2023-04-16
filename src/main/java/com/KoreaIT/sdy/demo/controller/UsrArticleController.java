package com.KoreaIT.sdy.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.sdy.demo.vo.Article;

@Controller
public class UsrArticleController {
	int lastArticle;
	List<Article> articles = new ArrayList<>();
	
	UsrArticleController() {
		lastArticle = 0;
		articles = new ArrayList<>();
	}
	
	@RequestMapping("/usr/article/dowrite")
	@ResponseBody
	public Article doWrite(String title, String body) {
		int id = lastArticle+1;
		
		Article article = new Article(id, title , body);
		articles.add(article);
		lastArticle++;
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles(String title, String body) {
		return articles;
	}
}
