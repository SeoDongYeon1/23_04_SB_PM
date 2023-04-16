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
	
	@RequestMapping("/usr/article/doWrite")
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
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {
		Article article = getArticleById(id);

		if(article==null) {
			return id + "번 글은 존재하지 않습니다.";
		}
		return article;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticleById(id);
		
		if(article==null) {
			return id + "번 게시글은 존재하지 않습니다.";
		}
		deleteArticle(id);
		return id + "번 게시글을 삭제했습니다.";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {
		Article article = getArticleById(id);
		
		if(article==null) {
			return id + "번 게시글은 존재하지 않습니다.";
		}
		modifyArticle(id, title, body);
		return id + "번 게시글을 수정했습니다." + article;
	}
	
	public Article getArticleById(int id) {
		for(Article article : articles) {
			if(article.getId()==id) {
				return article;
			}
		}
		return null;
	}
	
	private void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);
	}
	
	private void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
	}
}
