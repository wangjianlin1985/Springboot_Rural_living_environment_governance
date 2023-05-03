package com.lhz.project.service;

import com.lhz.project.entity.SysSerialNumber;
import com.lhz.project.mapper.SysSerialNumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lihz
 */
@Service
public class SysSerialNumberService {



    @Autowired
    SysSerialNumberMapper sysSerialNumberMapper;

    /**
     *  新增项目编号
     * @param serial
     * @param type
     * @return
     */
    public  int insertSelective(String serial,String type){
        SysSerialNumber ssn = new SysSerialNumber();
        ssn.setSerialType(type);
        ssn.setCode(serial.substring(0,serial.indexOf("_")));
        ssn.setMedian(serial.substring(serial.indexOf("_")+1,serial.lastIndexOf("_")));
        ssn.setNum(serial.substring(serial.lastIndexOf("_")+1));
        ssn.setSerialNo(serial);

        return sysSerialNumberMapper.insertSelective(ssn);
    };


    /**
     * 根据编号类型，获取编号
     * @param record
     * @return
     */
    public String getSerialNo(SysSerialNumber record){
        String date ="";
        //设置日期格式
        //年月日
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        date = df.format(new Date());
        record.setMedian(date);

        Integer count = sysSerialNumberMapper.getNumber(record);
        int num=1;
        if(count!=0){
            //序号
            num = count+1;
        }
        //补全三个0
        String no= String.format("%3d",num).replaceAll(" ","0");

        String code="";
        //如果为入库单，则入库编码用RK
        if(record.getSerialType().equals("rk")){
            code="RK";
        }
        //如果为销售单，则入库编码用RK
        if(record.getSerialType().equals("mx")){
            code="MX";
        }
        //如果为商品编号，则入库编码用商品
        if(record.getSerialType().equals("sp")){
            code="SP";
        }

        StringBuffer sb = new StringBuffer();
        sb.append(code);
        sb.append("_");
        sb.append(date);
        sb.append("_");
        sb.append(no);

        return sb.toString();
    };


    /**
     * 修改项目编号
     * @param record
     * @return
     */
    public  int updateByPrimaryKeySelective(SysSerialNumber record){


        return sysSerialNumberMapper.updateByPrimaryKeySelective(record);
    };




}