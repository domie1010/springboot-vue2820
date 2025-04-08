package com.entity.view;

import com.entity.MinganEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 敏感词
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("mingan")
public class MinganView extends MinganEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 敏感等级类型的值
		*/
		private String minganValue;



	public MinganView() {

	}

	public MinganView(MinganEntity minganEntity) {
		try {
			BeanUtils.copyProperties(this, minganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 敏感等级类型的值
			*/
			public String getMinganValue() {
				return minganValue;
			}
			/**
			* 设置： 敏感等级类型的值
			*/
			public void setMinganValue(String minganValue) {
				this.minganValue = minganValue;
			}










}
