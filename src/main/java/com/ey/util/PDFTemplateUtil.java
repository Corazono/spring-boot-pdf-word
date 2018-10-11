package com.ey.util;

import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Locale;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freemarker模板生成PDF工具类
 * @author Corazono
 */
public class PDFTemplateUtil {

	/**
	 * classpath路径
	 */
	private String classpath = getClass().getResource("/").getPath();
	
	/**
	 * 指定FreeMarker模板文件的位置
	 */ 
	private String templatePath = "/templates";
	
	/**
	 * freeMarker模板文件名称
	 */
	private String templateFileName = "pdf.ftl";
	
	/**
	 * 指定编码
	 */
	private String encoding = "UTF-8";

	/**
	 * 字体资源文件 存放路径
	 */
	private String fontPath = "font/";

	/**
	 * 字体   [宋体][simsun.ttc]   [黑体][simhei.ttf]
	 */
	private String font = "simsun.ttc";

	/**
	 * 生成pdf
	 * @param data  传入到freemarker模板里的数据
	 * @param out   生成的pdf文件流
	 */
	public void createPDF(Object data, OutputStream out) {
		// 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		// 指定FreeMarker模板文件的位置
		cfg.setClassForTemplateLoading(getClass(), templatePath);
		
		ITextRenderer renderer = new ITextRenderer();
		try {
			// 设置 css中 的字体样式（暂时仅支持宋体和黑体）
			renderer.getFontResolver().addFont(classpath + fontPath + font, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			// 设置模板的编码格式
			cfg.setEncoding(Locale.CHINA, encoding);
			// 获取模板文件 template.ftl
			Template template = cfg.getTemplate(templateFileName, encoding);
			StringWriter writer = new StringWriter();
			// 将数据输出到html中
			template.process(data, writer);
			writer.flush();

			String html = writer.toString();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(out, false);
			renderer.finishPDF();
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}


	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}


	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}



}
