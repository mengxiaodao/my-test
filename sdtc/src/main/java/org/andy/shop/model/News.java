package org.andy.shop.model;

import java.util.Date;


/**
 * News
 * @author  <Auto generate>
 * @version  2018-10-20 14:52:15
 * table: news
 */
public class News {
	
	//columns START
	//id
	private Long id;
		
	//标题
	private String title;
		
	//副标题
	private String subTitle;
		
	//缩略图
	private String thumbnail;
		
	//内容
	private String content;
		
	//类型:1-头条;2-百科;3-行业
	private Integer type;
		
	//create_by
	private Long createBy;
		
	//创建人名称
	private String createName;
		
	//create_time
	private Date createTime;
		
	//是否删除:0-未删除;1-已删除
	private Integer isDeleted;
		
	//columns END 数据库字段结束
	
	


	//get and set
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getTitle() {
		return this.title;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	
	public String getSubTitle() {
		return this.subTitle;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	public String getThumbnail() {
		return this.thumbnail;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getContent() {
		return this.content;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	public Integer getType() {
		return this.type;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	
	
	public Long getCreateBy() {
		return this.createBy;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	
	
	public String getCreateName() {
		return this.createName;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	public Integer getIsDeleted() {
		return this.isDeleted;
	}

	
	
}

	
