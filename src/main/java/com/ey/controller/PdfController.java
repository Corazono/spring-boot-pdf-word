package com.ey.controller;

import com.ey.service.PdfService;
import com.ey.util.DownloadFileUtil;
import com.ey.util.PDFTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Created by Corazono on 2018/10/11.
 */
@RestController
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private PdfService pdfService;

    @RequestMapping("/getPdf")
    public  void getPdf(HttpServletResponse response){
        System.out.println("调用方法");
        Map<String, Object> data = pdfService.getPdf();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtil.setResponseHeader(response,"testPdf.pdf");
        PDFTemplateUtil myPdf = new PDFTemplateUtil();
        myPdf.createPDF(data, out);
    }
}
