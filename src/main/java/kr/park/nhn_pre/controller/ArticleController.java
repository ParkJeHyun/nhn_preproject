package kr.park.nhn_pre.controller;

import kr.park.nhn_pre.dao.ArticleDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016-12-19.
 */
@Controller
public class ArticleController {
    @Resource(name = "ArticleDao")
    private ArticleDao articleDao;

    @RequestMapping("/")
    public String getArticles(Model model) {
        model.addAttribute("article", articleDao.getPasswordById("1"));

        return "index";
    }
}
