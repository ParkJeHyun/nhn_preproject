package kr.park.nhn_pre.controller;

import kr.park.nhn_pre.artifacts.Article;
import kr.park.nhn_pre.dao.ArticleDao;
import kr.park.nhn_pre.util.EmailCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016-12-19.
 */
@Controller
public class ArticleController {
    @Resource(name = "ArticleDao")
    private ArticleDao articleDao;

    @RequestMapping("/")
    public String getArticles(Model model) {
        //Main 페이지에서 Article 리스트를 불러오기 위한 Controller
        model.addAttribute("articles", articleDao.getAllArticle());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Article article, HttpServletResponse response) {
        //Article을 추가
        try {
            if(EmailCheck.checkEmail(article.getEmail())){
                //Email 형식이 제대로 됨
                response.getWriter().print(articleDao.insertArticle(article));
            }
            else {
                //Email의 형식이 잘못됨
                response.getWriter().print(2);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/password/{id}", method = RequestMethod.GET)
    public void getPassword(@PathVariable String id, HttpServletResponse response) {
        //해당 id의 Article의 비밀번호 부르기
        try {
            response.getWriter().print(articleDao.getPasswordById(id));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public void modify(@PathVariable String id, @RequestBody String text, HttpServletResponse response) {
        //Article의 내용 변경
        Article article = articleDao.getArticleById(id);
        article.setText(text);

        try {
            response.getWriter().print(articleDao.modifyArticle(article));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id, HttpServletResponse response) {
        //id에 해당하는 Article삭제
        try {
            response.getWriter().print(articleDao.deleteArticleById(id));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
