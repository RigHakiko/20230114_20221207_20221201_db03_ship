package com.example.db03_ship_20221201.service.impl;

import com.example.db03_ship_20221201.entity.Ship;
import com.example.db03_ship_20221201.mapper.ShipMapper;
import com.example.db03_ship_20221201.searchBody.ShipSearchBody;
import com.example.db03_ship_20221201.service.IShipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
@Service
public class ShipServiceImpl extends ServiceImpl<ShipMapper, Ship> implements IShipService {

    @Override
    public List<Ship> select(ShipSearchBody shipSearchBody) {
        return null;
    }

    @Override
    public Integer counts(ShipSearchBody shipSearchBody) {
        return null;
    }
}
