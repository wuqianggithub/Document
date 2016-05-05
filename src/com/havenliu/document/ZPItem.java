/**
 * Project Name:Document
 * File Name:ZPItem.java
 * Package Name:com.havenliu.document
 * Date:2014年12月31日上午11:15:13
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.havenliu.document;

import java.util.List;

/**
 * ClassName:ZPItem <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月31日 上午11:15:13 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ZPItem {
	private String evaluatorItemParentName;
	private String averageSocre;
	private List<NoPassItem> noPassItemList;
	private List<PGItem> PGItemList;
	private List<String> chNames;
	public List<String> getChNames() {
		return chNames;
	}

	public void setChNames(List<String> chNames) {
		this.chNames = chNames;
	}

	public List<PGItem> getPGItemList() {
		return PGItemList;
	}

	public void setPGItemList(List<PGItem> pGItemList) {
		PGItemList = pGItemList;
	}

	public List<NoPassItem> getNoPassItemList() {
		return noPassItemList;
	}

	public void setNoPassItemList(List<NoPassItem> noPassItemList) {
		this.noPassItemList = noPassItemList;
	}

	public String getAverageSocre() {
		return averageSocre;
	}

	public void setAverageSocre(String averageSocre) {
		this.averageSocre = averageSocre;
	}

	private List<ChildItem> childItem;

	public List<ChildItem> getChildItem() {
		return childItem;
	}

	public void setChildItem(List<ChildItem> childItem) {
		this.childItem = childItem;
	}

	public String getEvaluatorItemParentName() {
		return evaluatorItemParentName;
	}

	public void setEvaluatorItemParentName(String evaluatorItemParentName) {
		this.evaluatorItemParentName = evaluatorItemParentName;
	}
	
}

