package com.tz.online.address.service;

import com.tz.online.entity.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 16:04.
 * Project: BookStore01.
 */
public interface IAddressService {
    Province findProvinceByCode(String code);

    City findCityByCode(String code);

    Area findAreaByCode(String code);

    boolean clearDefaultAddressForUser(User user);

    Address findDefaultAddressByUser(User user);
}
