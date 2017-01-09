package com.tz.online.ssxjl.dao.impl;

import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 10:22.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class SSXJLDaoImplTest extends AbstractTestNGSpringContextTests {
    @Resource
    private ISSXJLDao ssxjlDao;

    @Test
    public void selectAllProvinces() throws Exception {
        List<Province> provinceList = ssxjlDao.selectAllProvinces();
        provinceList.forEach(System.out::println);
    }

    @Test
    public void selectCityByProvinceCode() throws Exception {

    }

    @Test
    public void selectAreaByCityCode() throws Exception {

    }

}