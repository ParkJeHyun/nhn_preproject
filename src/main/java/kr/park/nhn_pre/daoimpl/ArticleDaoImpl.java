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
        //DB에 있는 모든 Article 불러오기
        List<Article> articles = sqlSession.selectList("getArticle");

        return articles;
    }

    public Article getArticleById(String id){
        //ID에 해당하는 Article 불러오기
        Article article = sqlSession.selectOne("getArticleById", id);

        return article;
    }

    public String getPasswordById(String id) {
        //ID에 해당하는 Article의 비밀번호 불러오기
        String password = sqlSession.selectOne("getPasswordById", id);

        return password;
    }

    public Integer insertArticle(Article article){
        //Article 추가
        return sqlSession.insert("insertArticle", article);
    }

    public Integer modifyArticle(Article article) {
        //Article 변경
        return sqlSession.update("modifyArticle", article);
    }

    public Integer deleteArticleById(String id) {
        //ID에 해당하는 Article 삭제
        return sqlSession.delete("removeArticleById", id);
    }
}
