package com.tz.online.ssxjl.dao;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;

import java.util.List;

public interface ISSXJLDao {
    /**
     * 查询所有省份
     */
    List<Province> selectAllProvinces();

    /**
     * 根据省份编号查询城市
     */
    List<City> selectCityByProvinceCode(String provinceCode);

    /**
     * 根据城市编号查询区域
     */
    List<Area> selectAreaByCityCode(String cityCode);
}
