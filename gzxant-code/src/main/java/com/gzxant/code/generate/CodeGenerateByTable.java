//package com.gzxant.code.generate;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import freemarker.template.TemplateException;
//
//public class CodeGenerateByTable {
//	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, TemplateException {
//        //表名
//        String tableName = "shop_product";
//        //生成文件路径
//        String autoGeneratedFile = "F:\\temp\\auto-code";
//        //实例化
//        CodeGenerate codeGenerate = new CodeGenerate(tableName,autoGeneratedFile);
//        
//        //调用生成java代码方法
//        codeGenerate.autoGenerationJavaCode();
//    }
//}