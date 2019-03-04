package com.yqx.util;

import java.util.List;

public class Pager<T> {
	/*
	 * ҳ��
	 * */
	private int sp;
	/*
	 * ÿҳ��¼��
	 * */
	private int pageSize = 20;
	/*
	 * �ܼ�¼��
	 * */
	private int totals;
	/*
	 * ��ҳ��
	 * */
	private int pageCounts;
	/*
	 * ��װ����
	 * */
	private List<T> list;
	
	public Pager(int totals,String currentPage) {
		this.totals = totals;
		try {
			this.sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			this.sp = 1;
		}
		this.pageCounts = this.totals/this.pageSize;
		if(this.totals%this.pageSize != 0) {
			this.pageCounts++;
		}
		if(this.sp > this.pageCounts) {
			this.sp = this.pageCounts;
		}
		if(this.sp < 1) {
			this.sp = 1;
		}

	}

	public Pager() {
		super();
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	public int getPageCounts() {
		return pageCounts;
	}

	public void setPageCounts(int pageCounts) {
		this.pageCounts = pageCounts;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
