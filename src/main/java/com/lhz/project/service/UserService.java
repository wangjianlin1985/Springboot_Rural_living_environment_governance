package com.lhz.project.service;

import com.lhz.project.entity.SysSerialNumber;
import com.lhz.project.mapper.SysSerialNumberMapper;
import com.lhz.project.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lihz
 */
@Service
public class UserService {



    @Autowired
    SysUserMapper sysUserMapper;



}