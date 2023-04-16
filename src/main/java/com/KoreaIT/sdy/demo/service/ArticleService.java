package com.KoreaIT.sdy.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.KoreaIT.sdy.demo.vo.Article;

@Service
public class ArticleService {
	private int lastArticle;
	private List<Article> articles;
	
	ArticleService() {
		lastArticle = 0;
		articles = new ArrayList<>();
	}
	
	public Article getArticleById(int id) {
		for(Article article : articles) {
			if(article.getId()==id) {
				return article;
			}
		}
		return null;
	}
	
	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);
	}
	
	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
	}

	public Article writeArticle(String title, String body) {
		int id = lastArticle+1;
		
		Article article = new Article(id, title , body);
		articles.add(article);
		lastArticle++;
		
		return article;
	}

	public List<Article> getArticles() {
		return articles;
	}
}
