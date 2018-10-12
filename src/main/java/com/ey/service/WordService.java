package com.ey.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Corazono on 2018/10/12.
 */
@Service
public class WordService {
    public Map<String, Object> getWord(){
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("mail", "916185@qq.com");
        data.put("password", "3.14ferg");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sf.format(new Date());
        data.put("createTime", date);
        return data;
    }
}
