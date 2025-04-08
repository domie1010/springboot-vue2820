package com.entity.view;

import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 章节
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhangjie")
public class ZhangjieView extends ZhangjieEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shuji
			/**
			* 书籍名称
			*/
			private String shujiName;
			/**
			* 书籍封面
			*/
			private String shujiPhoto;
			/**
			* 书籍类型
			*/
			private Integer shujiTypes;
				/**
				* 书籍类型的值
				*/
				private String shujiValue;
			/**
			* 点击次数
			*/
			private Integer shujiClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 书籍简介
			*/
			private String shujiContent;

	public ZhangjieView() {

	}

	public ZhangjieView(ZhangjieEntity zhangjieEntity) {
		try {
			BeanUtils.copyProperties(this, zhangjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set shuji
					/**
					* 获取： 书籍名称
					*/
					public String getShujiName() {
						return shujiName;
					}
					/**
					* 设置： 书籍名称
					*/
					public void setShujiName(String shujiName) {
						this.shujiName = shujiName;
					}
					/**
					* 获取： 书籍封面
					*/
					public String getShujiPhoto() {
						return shujiPhoto;
					}
					/**
					* 设置： 书籍封面
					*/
					public void setShujiPhoto(String shujiPhoto) {
						this.shujiPhoto = shujiPhoto;
					}
					/**
					* 获取： 书籍类型
					*/
					public Integer getShujiTypes() {
						return shujiTypes;
					}
					/**
					* 设置： 书籍类型
					*/
					public void setShujiTypes(Integer shujiTypes) {
						this.shujiTypes = shujiTypes;
					}


						/**
						* 获取： 书籍类型的值
						*/
						public String getShujiValue() {
							return shujiValue;
						}
						/**
						* 设置： 书籍类型的值
						*/
						public void setShujiValue(String shujiValue) {
							this.shujiValue = shujiValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getShujiClicknum() {
						return shujiClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setShujiClicknum(Integer shujiClicknum) {
						this.shujiClicknum = shujiClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 书籍简介
					*/
					public String getShujiContent() {
						return shujiContent;
					}
					/**
					* 设置： 书籍简介
					*/
					public void setShujiContent(String shujiContent) {
						this.shujiContent = shujiContent;
					}








}
