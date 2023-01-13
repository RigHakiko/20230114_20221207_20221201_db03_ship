package com.example.db03_ship_20221201.service;

import com.example.db03_ship_20221201.entity.Ship;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.db03_ship_20221201.searchBody.ShipSearchBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
public interface IShipService extends IService<Ship> {

    List<Ship> select(ShipSearchBody shipSearchBody) ;

    Integer counts(ShipSearchBody shipSearchBody);

}
