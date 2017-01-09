package com.tz.online.ssxjl.dao.impl;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/19 12:54.
 * Project: SSXJL.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class SSXJLDaoImpl implements ISSXJLDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Province> selectAllProvinces() {
        String sql = "SELECT ID,CODE,NAME FROM PROVINCE";
        // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Province.class));
        List<Province> provinceList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Province province = new Province();
            province.setProvinceId(((BigDecimal) row.get("id")).intValue());
            province.setProvinceCode((String) row.get("code"));
            province.setProvinceName((String) row.get("name"));
            provinceList.add(province);
        }
        return provinceList;
    }

    @Override
    public List<City> selectCityByProvinceCode(String provinceCode) {
        String sql = "SELECT ID,CODE,NAME FROM CITY WHERE PROVINCEID = ?";
        List<City> cityList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, provinceCode);
        for (Map<String, Object> row : rows) {
            City city = new City();
            city.setCityId(((BigDecimal) row.get("id")).intValue());
            city.setCityCode((String) row.get("code"));
            city.setCityName((String) row.get("name"));
            cityList.add(city);
        }
        return cityList;
    }

    @Override
    public List<Area> selectAreaByCityCode(String cityCode) {
        String sql = "SELECT ID,CODE,NAME FROM AREA WHERE CITYID = ?";
        List<Area> areaList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, cityCode);
        for (Map<String, Object> row : rows) {
            Area area = new Area();
            area.setAreaId(((BigDecimal) row.get("id")).intValue());
            area.setAreaCode((String) row.get("code"));
            area.setAreaName((String) row.get("name"));
            areaList.add(area);
        }
        return areaList;
    }
}
