








package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 作者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zuozhe")
public class ZuozheController {
    private static final Logger logger = LoggerFactory.getLogger(ZuozheController.class);

    @Autowired
    private ZuozheService zuozheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zuozheService.queryPage(params);

        //字典表数据转换
        List<ZuozheView> list =(List<ZuozheView>)page.getList();
        for(ZuozheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuozheEntity zuozhe = zuozheService.selectById(id);
        if(zuozhe !=null){
            //entity转view
            ZuozheView view = new ZuozheView();
            BeanUtils.copyProperties( zuozhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<ZuozheEntity> queryWrapper = new EntityWrapper<ZuozheEntity>()
            .eq("zuozhe_name", zuozhe.getZuozheName())
            .eq("zuozhe_phone", zuozhe.getZuozhePhone())
            .eq("zuozhe_id_number", zuozhe.getZuozheIdNumber())
            .eq("sex_types", zuozhe.getSexTypes())
            .eq("yonghu_email", zuozhe.getYonghuEmail())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuozheEntity zuozheEntity = zuozheService.selectOne(queryWrapper);
        if(zuozheEntity==null){
            zuozhe.setCreateTime(new Date());
            zuozheService.insert(zuozhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<ZuozheEntity> queryWrapper = new EntityWrapper<ZuozheEntity>()
            .notIn("id",zuozhe.getId())
            .andNew()
            .eq("zuozhe_name", zuozhe.getZuozheName())
            .eq("zuozhe_phone", zuozhe.getZuozhePhone())
            .eq("zuozhe_id_number", zuozhe.getZuozheIdNumber())
            .eq("sex_types", zuozhe.getSexTypes())
            .eq("yonghu_email", zuozhe.getYonghuEmail())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuozheEntity zuozheEntity = zuozheService.selectOne(queryWrapper);
        if("".equals(zuozhe.getZuozhePhoto()) || "null".equals(zuozhe.getZuozhePhoto())){
                zuozhe.setZuozhePhoto(null);
        }
        if(zuozheEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zuozhe.set
            //  }
            zuozheService.updateById(zuozhe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zuozheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZuozheEntity> zuozheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZuozheEntity zuozheEntity = new ZuozheEntity();
//                            zuozheEntity.setZuozheName(data.get(0));                    //作者姓名 要改的
//                            zuozheEntity.setZuozhePhone(data.get(0));                    //作者手机号 要改的
//                            zuozheEntity.setZuozheIdNumber(data.get(0));                    //作者身份证号 要改的
//                            zuozheEntity.setZuozhePhoto("");//照片
//                            zuozheEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zuozheEntity.setYonghuEmail(data.get(0));                    //电子邮箱 要改的
//                            zuozheEntity.setZuozheContent("");//照片
//                            zuozheEntity.setCreateTime(date);//时间
                            zuozheList.add(zuozheEntity);


                            //把要查询是否重复的字段放入map中
                                //作者手机号
                                if(seachFields.containsKey("zuozhePhone")){
                                    List<String> zuozhePhone = seachFields.get("zuozhePhone");
                                    zuozhePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zuozhePhone = new ArrayList<>();
                                    zuozhePhone.add(data.get(0));//要改的
                                    seachFields.put("zuozhePhone",zuozhePhone);
                                }
                                //作者身份证号
                                if(seachFields.containsKey("zuozheIdNumber")){
                                    List<String> zuozheIdNumber = seachFields.get("zuozheIdNumber");
                                    zuozheIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zuozheIdNumber = new ArrayList<>();
                                    zuozheIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zuozheIdNumber",zuozheIdNumber);
                                }
                        }

                        //查询是否重复
                         //作者手机号
                        List<ZuozheEntity> zuozheEntities_zuozhePhone = zuozheService.selectList(new EntityWrapper<ZuozheEntity>().in("zuozhe_phone", seachFields.get("zuozhePhone")));
                        if(zuozheEntities_zuozhePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZuozheEntity s:zuozheEntities_zuozhePhone){
                                repeatFields.add(s.getZuozhePhone());
                            }
                            return R.error(511,"数据库的该表中的 [作者手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //作者身份证号
                        List<ZuozheEntity> zuozheEntities_zuozheIdNumber = zuozheService.selectList(new EntityWrapper<ZuozheEntity>().in("zuozhe_id_number", seachFields.get("zuozheIdNumber")));
                        if(zuozheEntities_zuozheIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZuozheEntity s:zuozheEntities_zuozheIdNumber){
                                repeatFields.add(s.getZuozheIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [作者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zuozheService.insertBatch(zuozheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zuozheService.queryPage(params);

        //字典表数据转换
        List<ZuozheView> list =(List<ZuozheView>)page.getList();
        for(ZuozheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuozheEntity zuozhe = zuozheService.selectById(id);
            if(zuozhe !=null){


                //entity转view
                ZuozheView view = new ZuozheView();
                BeanUtils.copyProperties( zuozhe , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());
        Wrapper<ZuozheEntity> queryWrapper = new EntityWrapper<ZuozheEntity>()
            .eq("zuozhe_name", zuozhe.getZuozheName())
            .eq("zuozhe_phone", zuozhe.getZuozhePhone())
            .eq("zuozhe_id_number", zuozhe.getZuozheIdNumber())
            .eq("sex_types", zuozhe.getSexTypes())
            .eq("yonghu_email", zuozhe.getYonghuEmail())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuozheEntity zuozheEntity = zuozheService.selectOne(queryWrapper);
        if(zuozheEntity==null){
            zuozhe.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zuozhe.set
        //  }
        zuozheService.insert(zuozhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
