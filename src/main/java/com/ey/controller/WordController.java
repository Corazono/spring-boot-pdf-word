package com.ey.controller;

import com.ey.service.WordService;
import com.ey.util.DownloadFileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by Corazono on 2018/10/11.
 */
@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @RequestMapping("/getWord")
    public  void getWord(HttpServletRequest request, HttpServletResponse response){
        System.out.println("调用方法");
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/msword");
        DownloadFileUtil.setResponseHeader(response,"测试.doc");
        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 指定FreeMarker模板文件的位置
        cfg.setClassForTemplateLoading(getClass(), "/templates");
        Template template = null;
        try {
            template = cfg.getTemplate("word.ftl","UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> root = wordService.getWord();
        try {
            template.process(root, new OutputStreamWriter(response.getOutputStream()));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
