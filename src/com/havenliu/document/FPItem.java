/**
 * Project Name:Document
 * File Name:FPItem.java
 * Package Name:com.havenliu.document
 * Date:2014年12月31日上午11:14:59
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.havenliu.document;

import java.util.List;

/**
 * ClassName:FPItem <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月31日 上午11:14:59 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FPItem {
	private String evaluatorItemParentName;
	private String evaluatorTaskScore;
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
	public String getEvaluatorTaskScore() {
		return evaluatorTaskScore;
	}
	public void setEvaluatorTaskScore(String evaluatorTaskScore) {
		this.evaluatorTaskScore = evaluatorTaskScore;
	}
	
}

