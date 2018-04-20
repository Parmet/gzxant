package com.gzxant.code.generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerate {
	private static String[] tableName = {"shop_goods_sku"};
	public static String author = "xiaoyc";
	public static String dataType = "base"; // tree, crud, base
	public static String output = "E:\\temp\\code-generate"; 

//	@Value("${spring.datasource.url}")
	public static String url = "jdbc:mysql://localhost:3306/gzxant?useUnicode=true&characterEncoding=utf8&useSSL=false";
//	@Value("${spring.datasource.username}")
	public static String name = "root";
//	@Value("${spring.datasource.password}")
	public static String passWord = "123456";
//	@Value("${spring.datasource.driver-class-name}")
	public static String driver = "com.mysql.jdbc.Driver";
	

	public static void main(String[] args) {
		
		AutoGenerator mpg = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Veloctiy
//		mpg.setTemplateEngine(new FreemarkerTemplateEngine());

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(output);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor(author);

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sDao");
		gc.setXmlName("%sDao");
		gc.setServiceName("I%sService");
		gc.setServiceImplName("%sService");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);
		
		// 自定义包配置
		PackageConfig pg = new PackageConfig();
		pg.setController("controller");
		pg.setXml("xml");
		
		mpg.setPackageInfo(pg);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);
				// 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
				return super.processTypeConvert(fieldType);
			}
		});
		dsc.setDriverName(driver);
		dsc.setUsername(name);
		dsc.setPassword(passWord);
		dsc.setUrl(url);
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		// strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude(tableName); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		if (dataType.equals("tree")) {
			strategy.setSuperEntityClass("com.gzxant.base.entity.TreeEntity");
			strategy.setSuperMapperClass("com.gzxant.base.dao.TreeDao");
		} else if (dataType.equals("crud")) {
			strategy.setSuperEntityClass("com.gzxant.base.entity.DataEntity");
			strategy.setSuperMapperClass("com.gzxant.base.dao.CrudDao");
		} else if (dataType.equals("base")) {
			strategy.setSuperEntityClass("com.gzxant.base.entity.BaseEntity");
			strategy.setSuperMapperClass("com.gzxant.base.dao.BaseDao");
		}
		// 自定义 service 父类
		strategy.setSuperServiceClass("com.gzxant.base.service.IBaseService");
		// 自定义 service 实现类父类
		strategy.setSuperServiceImplClass("om.gzxant.base.service.impl.BaseService");
		// 自定义 controller 父类
		strategy.setSuperControllerClass("com.gzxant.base.controller.BaseController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuilderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.gzxant");
//		pc.setModuleName("shop");
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("author", this.getConfig().getGlobalConfig().getAuthor());
				this.setMap(map);
			}
		};

		// 自定义 xxList.jsp 生成
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//		focList.add(new FileOutConfig("/template/list.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				// 自定义输入文件名称
//				return "D://my_" + tableInfo.getEntityName() + ".ftl";
//			}
//		});
//		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 调整 xml 生成目录演示
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 关闭默认 xml 生成，调整生成 至 根目录
//		TemplateConfig tc = new TemplateConfig();
//		tc.setXml(null);
//		mpg.setTemplate(tc);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
		// 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//		 TemplateConfig tc = new TemplateConfig();
//		 tc.setController("/templates/code/controllerTemplate.ftl");
//		 tc.setEntity(null);
//		 tc.setMapper("...");
//		 tc.setXml(null);
//		 tc.setService("...");
//		 tc.setServiceImpl("...");
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
//		 mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

		// 打印注入设置【可无】
		System.err.println(mpg.getCfg().getMap().get("abc"));

	}


}
