package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 敏感词
 *
 * @author 
 * @email
 */
@TableName("mingan")
public class MinganEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MinganEntity() {

	}

	public MinganEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 敏感词
     */
    @TableField(value = "mingan_name")

    private String minganName;


    /**
     * 敏感等级类型
     */
    @TableField(value = "mingan_types")

    private Integer minganTypes;


    /**
     * 备注
     */
    @TableField(value = "mingan_content")

    private String minganContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：敏感词
	 */
    public String getMinganName() {
        return minganName;
    }


    /**
	 * 获取：敏感词
	 */

    public void setMinganName(String minganName) {
        this.minganName = minganName;
    }
    /**
	 * 设置：敏感等级类型
	 */
    public Integer getMinganTypes() {
        return minganTypes;
    }


    /**
	 * 获取：敏感等级类型
	 */

    public void setMinganTypes(Integer minganTypes) {
        this.minganTypes = minganTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getMinganContent() {
        return minganContent;
    }


    /**
	 * 获取：备注
	 */

    public void setMinganContent(String minganContent) {
        this.minganContent = minganContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Mingan{" +
            "id=" + id +
            ", minganName=" + minganName +
            ", minganTypes=" + minganTypes +
            ", minganContent=" + minganContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
