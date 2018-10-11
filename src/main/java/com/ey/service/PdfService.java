package com.ey.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Corazono on 2018/10/11.
 */
@Service
public class PdfService {
    public Map<String, Object> getPdf(){
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("mail", "916185@qq.com");
        data.put("password", "3.14ferg");
        data.put("createTime", new Date());
        return data;
    }
}
