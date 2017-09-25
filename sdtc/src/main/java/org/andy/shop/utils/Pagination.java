package org.andy.shop.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> implements Serializable{
	public Pagination() {
		total = Integer.valueOf(0);
		rows = new ArrayList<T>();
		pageSize = Integer.valueOf(10);
		pageNum = Integer.valueOf(0);
		currentPage = Integer.valueOf(1);
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return Integer.valueOf(total.intValue() % pageSize.intValue() != 0 ? total.intValue() / pageSize.intValue() + 1
				: total.intValue() / pageSize.intValue());
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	private static final long serialVersionUID = 253167141465129702L;
	private Integer total;
	private List<T> rows;
	private Integer pageSize;
	private Integer pageNum;
	private Integer currentPage;
}
