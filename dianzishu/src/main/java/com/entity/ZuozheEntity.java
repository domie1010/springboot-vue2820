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
 * 作者
 *
 * @author 
 * @email
 */
@TableName("zuozhe")
public class ZuozheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZuozheEntity() {

	}

	public ZuozheEntity(T t) {
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
     * 作者姓名
     */
    @TableField(value = "zuozhe_name")

    private String zuozheName;


    /**
     * 作者手机号
     */
    @TableField(value = "zuozhe_phone")

    private String zuozhePhone;


    /**
     * 作者身份证号
     */
    @TableField(value = "zuozhe_id_number")

    private String zuozheIdNumber;


    /**
     * 作者头像
     */
    @TableField(value = "zuozhe_photo")

    private String zuozhePhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @TableField(value = "yonghu_email")

    private String yonghuEmail;


    /**
     * 作者简介
     */
    @TableField(value = "zuozhe_content")

    private String zuozheContent;


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
	 * 设置：作者姓名
	 */
    public String getZuozheName() {
        return zuozheName;
    }


    /**
	 * 获取：作者姓名
	 */

    public void setZuozheName(String zuozheName) {
        this.zuozheName = zuozheName;
    }
    /**
	 * 设置：作者手机号
	 */
    public String getZuozhePhone() {
        return zuozhePhone;
    }


    /**
	 * 获取：作者手机号
	 */

    public void setZuozhePhone(String zuozhePhone) {
        this.zuozhePhone = zuozhePhone;
    }
    /**
	 * 设置：作者身份证号
	 */
    public String getZuozheIdNumber() {
        return zuozheIdNumber;
    }


    /**
	 * 获取：作者身份证号
	 */

    public void setZuozheIdNumber(String zuozheIdNumber) {
        this.zuozheIdNumber = zuozheIdNumber;
    }
    /**
	 * 设置：作者头像
	 */
    public String getZuozhePhoto() {
        return zuozhePhoto;
    }


    /**
	 * 获取：作者头像
	 */

    public void setZuozhePhoto(String zuozhePhoto) {
        this.zuozhePhoto = zuozhePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYonghuEmail() {
        return yonghuEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setYonghuEmail(String yonghuEmail) {
        this.yonghuEmail = yonghuEmail;
    }
    /**
	 * 设置：作者简介
	 */
    public String getZuozheContent() {
        return zuozheContent;
    }


    /**
	 * 获取：作者简介
	 */

    public void setZuozheContent(String zuozheContent) {
        this.zuozheContent = zuozheContent;
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
        return "Zuozhe{" +
            "id=" + id +
            ", zuozheName=" + zuozheName +
            ", zuozhePhone=" + zuozhePhone +
            ", zuozheIdNumber=" + zuozheIdNumber +
            ", zuozhePhoto=" + zuozhePhoto +
            ", sexTypes=" + sexTypes +
            ", yonghuEmail=" + yonghuEmail +
            ", zuozheContent=" + zuozheContent +
            ", createTime=" + createTime +
        "}";
    }
}
