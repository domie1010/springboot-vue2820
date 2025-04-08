package com.entity.vo;

import com.entity.MinganEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 敏感词
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mingan")
public class MinganVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
