package com.dao;

import com.entity.MinganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MinganView;

/**
 * 敏感词 Dao 接口
 *
 * @author 
 */
public interface MinganDao extends BaseMapper<MinganEntity> {

   List<MinganView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
