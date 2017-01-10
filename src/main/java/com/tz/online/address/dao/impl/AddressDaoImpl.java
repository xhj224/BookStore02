package com.tz.online.address.dao.impl;

import com.tz.online.address.dao.IAddressDao;
import com.tz.online.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 15:22.
 * Project: BookStore01.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AddressDaoImpl implements IAddressDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Province selectProvinceById(String id) {
        String sql = "SELECT ID,CODE,NAME FROM PROVINCE WHERE CODE=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            Province province = new Province();
            province.setProvinceId(resultSet.getInt("id"));
            province.setProvinceCode(resultSet.getString("code"));
            province.setProvinceName(resultSet.getString("name"));
            return province;
        });
    }

    @Override
    public City selectCityById(String id) {
        String sql = "SELECT ID,CODE,NAME FROM CITY WHERE CODE=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            City city = new City();
            city.setCityId(resultSet.getInt("id"));
            city.setCityCode(resultSet.getString("code"));
            city.setCityName(resultSet.getString("name"));
            return city;
        });
    }

    @Override
    public Area selectAreaById(String id) {
        String sql = "SELECT ID,CODE,NAME FROM AREA WHERE CODE=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            Area area = new Area();
            area.setAreaId(resultSet.getInt("id"));
            area.setAreaCode(resultSet.getString("code"));
            area.setAreaName(resultSet.getString("name"));
            return area;
        });
    }

    @Override
    public boolean updateDefaultAddressForUser(User user) {
        try {
            String hql = "update Address set isDefault='0' where user=:user";
            getSession().createQuery(hql).setParameter("user", user).executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Address selectDefaultAddressByUser(User user) {
        String hql = "from Address where user=:user and isDefault='1'";
        return (Address) getSession().createQuery(hql).setParameter("user", user).uniqueResult();
    }
}
