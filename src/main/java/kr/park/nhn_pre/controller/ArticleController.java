package kr.park.nhn_pre.controller;

import kr.park.nhn_pre.artifacts.Article;
import kr.park.nhn_pre.dao.ArticleDao;
import kr.park.nhn_pre.util.EmailCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("articles", articleDao.getAllArticle());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Article article, HttpServletResponse response) {
        try {
            if(EmailCheck.checkEmail(article.getEmail())){
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
}
