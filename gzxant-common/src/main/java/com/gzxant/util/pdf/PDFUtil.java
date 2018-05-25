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

import com.gzxant.util.image.ocr.huawei.ImageUtil;

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
		List<String> txts = new ArrayList<>();
		
		// 2. 将图片转成文字
		for (String img : imgs) {
			txts.add(ImageUtil.img2Str(img));
		}
		
		// 3. 保存到文件
		String txtPath = getTxtPath(pdfPath);
		writeContent2Txt(txts, txtPath);
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
		String savePath = pdfPath.substring(0, pdfPath.length() - 4);
		File saveFile = new File(savePath);
		if(!saveFile.exists() && !saveFile.isDirectory()){
			saveFile.mkdirs();
		}
		
		// txt文件名称统一为content.txt
		String filePath = savePath + "content.txt";
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return filePath;
	}

	/**
	 * 
	 * @param al
	 * @param file
	 */
	private static void writeContent2Txt(List<String> al, String file) {
		File f = new File(file);
        BufferedWriter bw = null;
        
		try {
			bw = new BufferedWriter(new FileWriter(f));
	        for (int i = 0 ; i < al.size() ; i++) {
				bw.write(al.get(i));
				bw.newLine();
	        }
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
				ImageIOUtil.writeImage(bim, savePath + "/" + (pageCounter++) + ".png", 600);
				results.add(savePath + "/" + pageCounter + ".png");
			}

			document.close();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return results;
	}
}
