package com.entity.model;

import com.entity.MinganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 敏感词
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MinganModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 敏感词
     */
    private String minganName;


    /**
     * 敏感等级类型
     */
    private Integer minganTypes;


    /**
     * 备注
     */
    private String minganContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：敏感词
	 */
    public String getMinganName() {
        return minganName;
    }


    /**
	 * 设置：敏感词
	 */
    public void setMinganName(String minganName) {
        this.minganName = minganName;
    }
    /**
	 * 获取：敏感等级类型
	 */
    public Integer getMinganTypes() {
        return minganTypes;
    }


    /**
	 * 设置：敏感等级类型
	 */
    public void setMinganTypes(Integer minganTypes) {
        this.minganTypes = minganTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getMinganContent() {
        return minganContent;
    }


    /**
	 * 设置：备注
	 */
    public void setMinganContent(String minganContent) {
        this.minganContent = minganContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
