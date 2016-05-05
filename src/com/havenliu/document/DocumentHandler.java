package com.havenliu.document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocumentHandler {
	private Configuration configuration = null;

	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
	}

	public void createDoc() {
		//要填入模本的数据文件
		Map<String,Object> dataMap=new HashMap<String,Object>();
		getData2(dataMap);
		//设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
		//这里我们的模板是放在com.havenliu.document.template包下面
		configuration.setClassForTemplateLoading(this.getClass(), "/com/havenliu/document/template");
		Template t=null;
		try {
			//test.ftl为要装载的模板
			//t = configuration.getTemplate("test.ftl");
			t = configuration.getTemplate("yjReport.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//输出文档路径及名称
		File outFile = new File("D:/temp/outFile.doc");
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 
        try {
			t.process(dataMap, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * @param dataMap
	 */
	 private void getData(Map<String,Object> dataMap)
	  {
		  dataMap.put("author", "张三");
		  dataMap.put("remark", "这是测试备注信息");
		  List<Table1> _table1=new ArrayList<Table1>();
		  
		  Table1 t1=new Table1();
		  t1.setDate("2010-10-1");
		  t1.setText("制定10月开发计划内容。");
		  _table1.add(t1);
		  
		  Table1 t2=new Table1();
		  t2.setDate("2010-10-2");
		  t2.setText("开会讨论开发计划");
		  _table1.add(t2);
		  
		  dataMap.put("table1", _table1);
		  
		  
		  List<Table2> _table2=new ArrayList<Table2>();
		  for(int i=0;i<5;i++)
		  {
			  Table2 _t2=new Table2();
			  _t2.setDetail("测试开发计划"+i);
			  _t2.setPerson("张三——"+i);
			  _t2.setBegindate("2010-10-1");
			  _t2.setFinishdate("2010-10-31");
			  _t2.setRemark("备注信息");
			  _table2.add(_t2);
		  }
		  dataMap.put("table2", _table2);
		  
	  }

	 
	 private void getData2(Map<String,Object> dataMap)
	  {
		  dataMap.put("playName", "影片名称");
		  dataMap.put("baseDataName", "剧本类别");
		  //dataMap.put("chName", "评估人");
		  dataMap.put("filename", "其他上传文件名称");
		  dataMap.put("columnPageName", "电影预计时长");
		  dataMap.put("dynamicColumnsValue", "xx集");
		  dataMap.put("createDate", "评估设置发送通知时间");
		  dataMap.put("updateDate", "评估报告生成时间");
		  dataMap.put("scoreName", "潜力说明与风险分析");
		  dataMap.put("scoreValues", "5分制");
		  dataMap.put("fileContent", "故事大纲的文本内容");
		  dataMap.put("evaluatorItemParentName", "选点创意");
		  //dataMap.put("evaluatorItemChildName", "故事主线分析");
		  //dataMap.put("evaluatorTaskScore", "每项打分分值");
		  dataMap.put("secView", "核心观点");
		  //dataMap.put("averageSocre", "平均分");
		  dataMap.put("allAverageSocre", "整体平均分");
		  List<String> chNames = new ArrayList<String>();
		  chNames.add("评估人A");
		  chNames.add("评估人B");
		  chNames.add("评估人C");
		  dataMap.put("chNames", chNames);
		  
		  List<PGItem> pgItems=new ArrayList<PGItem>();
		  List<FPItem> fpItems=new ArrayList<FPItem>();
		  List<ZPItem> zpItems=new ArrayList<ZPItem>();
		  //***************************评估项************************
		  PGItem pgItem1 = new PGItem();
		  pgItem1.setScoreName("潜力说明与风险分析");
		  pgItem1.setScoreValues("5分制");
		  pgItems.add(pgItem1);
		  
		  PGItem pgItem2 = new PGItem();
		  pgItem2.setScoreName("剧本整体评估");
		  pgItem2.setScoreValues("7分制");
		  pgItems.add(pgItem2);
		  
		  dataMap.put("pgItems", pgItems);
		  //***************************评估项************************
		  
		  //******************************复评**************************
		  FPItem t1=new FPItem();
		  t1.setEvaluatorItemParentName("选点创意");
		  t1.setEvaluatorTaskScore("5<w:br />");
		  ChildItem item1= new ChildItem();
		  item1.setEvaluatorItemChildName("故事主线分析");
		  ChildItem item2= new ChildItem();
		  item2.setEvaluatorItemChildName("故事重点分析");
		  List<ChildItem> itemList1 = new ArrayList<ChildItem>();
		  itemList1.add(item1);
		  itemList1.add(item2);
		  t1.setChildItem(itemList1);
		  fpItems.add(t1);
		  
		  FPItem t2=new FPItem();
		  t2.setEvaluatorItemParentName("故事框架");
		  t2.setEvaluatorTaskScore("7<w:br />");
		  ChildItem item3= new ChildItem();
		  item3.setEvaluatorItemChildName("呈现形式分析");
		  ChildItem item4= new ChildItem();
		  item4.setEvaluatorItemChildName("观看习惯分析");
		  List<ChildItem> itemList2 = new ArrayList<ChildItem>();
		  itemList2.add(item3);
		  itemList2.add(item4);
		  t2.setChildItem(itemList2);
		  fpItems.add(t2);
		  dataMap.put("fpItems", fpItems);
		  //******************************复评**************************
		  
		  //******************************终评**************************
		  ZPItem t3=new ZPItem();
		  t3.setEvaluatorItemParentName("主题与前提");
		  t3.setAverageSocre("4");
		  ChildItem item5= new ChildItem();
		  item5.setEvaluatorItemChildName("本剧之主题是否积极、健康、向上");
		  item5.setEvaluatorTaskScore("5");
		  ChildItem item6= new ChildItem();
		  item6.setEvaluatorItemChildName("本剧之主题是否特别？是否吸引人？是否可形成话题性");
		  item6.setEvaluatorTaskScore("6");
		  List<ChildItem> itemList3 = new ArrayList<ChildItem>();
		  itemList3.add(item5);
		  itemList3.add(item6);
		  t3.setChildItem(itemList3);
		  zpItems.add(t3);
		  
		  ZPItem t4=new ZPItem();
		  t4.setEvaluatorItemParentName("人物");
		  t4.setAverageSocre("5");
		  ChildItem item7= new ChildItem();
		  item7.setEvaluatorItemChildName("主要角色之性格与命运是否具有特殊性？");
		  item7.setEvaluatorTaskScore("5");
		  ChildItem item8= new ChildItem();
		  item8.setEvaluatorItemChildName("观看习惯分析");
		  item8.setEvaluatorTaskScore("6");
		  List<ChildItem> itemList4 = new ArrayList<ChildItem>();
		  itemList4.add(item7);
		  itemList4.add(item8);
		  t4.setChildItem(itemList4);
		  zpItems.add(t4);
		  dataMap.put("zpItems", zpItems);
	  }
	
	 
	 private void getData3(Map<String,Object> dataMap)
	  {
		  dataMap.put("playName", "影片名称");
		  dataMap.put("baseDataName", "剧本类别");
		  dataMap.put("filename", "其他上传文件名称");
		  dataMap.put("columnPageName", "电影预计时长");
		  dataMap.put("dynamicColumnsValue", "xx集");
		  dataMap.put("createDate", "评估设置发送通知时间");
		  dataMap.put("updateDate", "评估报告生成时间");
		  dataMap.put("fileContent", "故事大纲的文本内容");
		  dataMap.put("evaluatorItemParentName", "选点创意");
		  List<String> chNames = new ArrayList<String>();
		  chNames.add("评估人A");
		  chNames.add("评估人B");
		  chNames.add("评估人C");
		  dataMap.put("chNames", chNames);
		  List<PGItem> pgItems=new ArrayList<PGItem>();
		  
		  PGItem pg1 = new PGItem();
		  pg1.setScoreName("aaaaa");
		  pg1.setScoreValues("1");
		  PGItem pg2 = new PGItem();
		  pg2.setScoreName("bbbb");
		  pg2.setScoreValues("2");
		  pgItems.add(pg1);
		  pgItems.add(pg2);
		  
		  dataMap.put("PGItemList", pgItems);
		  
		  List<NoPassItem> noPassItemList = new ArrayList<NoPassItem>();
		  NoPassItem n1 = new NoPassItem();
		  n1.setBaseDataName("AAAAA");
		  n1.setBaseDataName("BBBBBBB");
		  NoPassItem n2 = new NoPassItem();
		  n2.setBaseDataName("CCCCCC");
		  n2.setBaseDataName("DDDDDD");
		  noPassItemList.add(n1);
		  noPassItemList.add(n2);
		  
		  dataMap.put("noPassItemList", noPassItemList);
	  }

}
