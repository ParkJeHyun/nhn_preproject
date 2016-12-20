package kr.park.nhn_pre.daoimpl;

import kr.park.nhn_pre.artifacts.Article;
import kr.park.nhn_pre.dao.ArticleDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016-12-19.
 */
@Repository("ArticleDao")
public class ArticleDaoImpl implements ArticleDao{
    @Autowired
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Article> getAllArticle() {
        List<Article> articles = sqlSession.selectList("getArticle");

        return articles;
    }

    public Article getArticleById(String id){
        Article article = sqlSession.selectOne("getArticleById", id);

        return article;
    }

    public String getPasswordById(String id) {
        String password = sqlSession.selectOne("getPasswordById", id);

        return password;
    }

    public Integer insertArticle(Article article){
        return sqlSession.insert("insertArticle", article);
    }

    public Integer modifyArticle(Article article) {
        return sqlSession.update("modifyArticle", article);
    }

    public Integer deleteArticleById(String id) {
        return sqlSession.delete("removeArticleById", id);
    }
}
