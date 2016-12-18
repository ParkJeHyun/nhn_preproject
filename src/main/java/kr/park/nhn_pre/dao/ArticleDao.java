package kr.park.nhn_pre.dao;

import kr.park.nhn_pre.artifacts.Article;

import java.util.List;

/**
 * Created by Administrator on 2016-12-19.
 */
public interface ArticleDao {
    List<Article> getAllArticle();

    String getPasswordById(String id);

    Integer insertArticle(Article article);

    Integer modifyArticle(Article article);

    Integer deleteArticleById(String id);
}
