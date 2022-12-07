package com.example.db03_ship_20221201.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.db03_ship_20221201.entity.ShipType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.db03_ship_20221201.searchBody.ShipTypeSearchBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
public interface IShipTypeService extends IService<ShipType> {

    Page<ShipType> all(Integer current);

    Page<ShipType> search(String keyword, Integer current);

    Page<ShipType> search2(ShipTypeSearchBody shipTypeSearchBody);
}
