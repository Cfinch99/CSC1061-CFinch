package edu.frcc.CSC1061jfa24.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class MyBookNode implements Comparable<MyBookNode>{
	private String title;
	private int chapNum;
	private int secNum;
	private int subSecNum;
	private String text;
	private List<MyBookNode> childNodes;
	
	public MyBookNode(String title, int chapNum, int secNum, int subSecNum, String text) {
		super();
		this.title = title;
		this.chapNum = chapNum;
		this.secNum = secNum;
		this.subSecNum = subSecNum;
		this.text = text;
		this.childNodes = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getChapNum() {
		return chapNum;
	}

	public void setChapNum(int chapNum) {
		this.chapNum = chapNum;
	}

	public int getSectNum() {
		return secNum;
	}

	public void setSection(int section) {
		this.secNum = section;
	}

	public int getSubSecNum() {
		return subSecNum;
	}

	public void setSubSecNum(int subSecNum) {
		this.subSecNum = subSecNum;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MyBookNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<MyBookNode> childNodes) {
		this.childNodes = childNodes;
	}
	
	
	@Override
	public int compareTo(MyBookNode o) {
		if (chapNum > o.chapNum) {
			return 1;
		}
		else if( chapNum < o.chapNum) {
			return -1;
		}
		
		if(secNum > o.secNum) {
			return 1;
		}
		else if (secNum < o.secNum) {
			return -1;
		}
		if(subSecNum > o.subSecNum) {
			return 1;
		}
		else if (subSecNum < o.subSecNum) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		if (chapNum == 0) {
			return title;
		}
		if (secNum == 0) {
			return "\t" + chapNum + " " + title;
		}
		if (subSecNum == 0) {
			return "\t\t" + chapNum + "." + secNum + " " + title;
		}
		return "\t\t\t" + chapNum + "." + secNum + "." + subSecNum + " " + title;
	}

	
	
}
