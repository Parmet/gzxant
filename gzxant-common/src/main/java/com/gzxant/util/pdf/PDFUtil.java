package com.gzxant.util.pdf;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import com.gzxant.util.image.ocr.aliyun.ImageUtils;

/**
 * pdf 工具
 * 
 * @author ycxiao
 * @since 2018-05-21
 */
public class PDFUtil {

	/**
	 * pdf转txt文件
	 * 
	 * @param pdfPath pdf路径
	 * @return
	 */
	public static String pdf2Txt(String pdfPath) {
		if (StringUtils.isBlank(pdfPath) || !pdfPath.endsWith(".pdf")) {
			return "";
		}
		
		// 1. pdf 分页转成图片
		List<String> imgs = pdf2Img(pdfPath);
		String imgStr = "";
		
		// 2. 将图片转成文字
		String txtPath = getTxtPath(pdfPath);
		for (int i = 0; i < imgs.size(); i++) {
			imgStr = ImageUtils.img2Str(imgs.get(i));
			String curTextPath = txtPath + File.separator + i + ".txt";
			writeContent2Txt(imgStr, curTextPath);
		}
		
		// 3. 保存到文件
		return txtPath;
	}
	
	/**
	 * 获取pdf对应txt文件路径，不存在则新建
	 * 
	 * @param pdfPath
	 * @return
	 */
	private static String getTxtPath(String pdfPath) {
		// 根据pdf名称生成目录
		String savePath = pdfPath.substring(0, pdfPath.length() - 4) + File.separator + "txt";
		File saveFile = new File(savePath);
		if(!saveFile.exists() && !saveFile.isDirectory()){
			saveFile.mkdirs();
		}
		
		return savePath;
	}

	/**
	 * 
	 * @param al
	 * @param file
	 */
	private static void writeContent2Txt(String al, String file) {
		File f = new File(file);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
        BufferedWriter bw = null;
        
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(al);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * pdf 分页转成图片
	 * 
	 * @param pdfPath
	 * @return
	 */
	@SuppressWarnings("unused")
	public static List<String> pdf2Img(String pdfPath) {
		List<String> results = new ArrayList<>();
		if (StringUtils.isBlank(pdfPath) || !pdfPath.endsWith(".pdf")) {
			return results;
		}
		
		// 按pdf名称创建目录
		String savePath = pdfPath.substring(0, pdfPath.length() - 4);
		File saveFile = new File(savePath);
		if(!saveFile.exists() && !saveFile.isDirectory()){
			saveFile.mkdirs();
		}
		
		// pdf转图片
		try {
			PDDocument document = PDDocument.load(new File(pdfPath));
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			int pageCounter = 0;
			for (PDPage page : document.getPages())
			{
				BufferedImage bim = pdfRenderer.renderImageWithDPI(pageCounter, 600, ImageType.RGB);
				ImageIOUtil.writeImage(bim, savePath + File.separator + (pageCounter) + ".jpg", 600);
				results.add(savePath + File.separator + pageCounter + ".jpg");
				pageCounter = pageCounter + 1;
			}

			document.close();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		String path = "F:\\gzxant\\file\\项目\\设备检测\\需求文档\\标准pdf\\GB 1886.25-2016 食品安全国家标准 食品添加剂 柠檬酸钠.pdf";
		PDFUtil.pdf2Txt(path);
	}
}
