package com.example.db03_ship_20221201.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.db03_ship_20221201.entity.Ship;
import com.example.db03_ship_20221201.entity.ShipType;
import com.example.db03_ship_20221201.mapper.ShipTypeMapper;
import com.example.db03_ship_20221201.searchBody.ShipTypeSearchBody;
import com.example.db03_ship_20221201.service.IShipTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ShipTypeServiceImpl extends ServiceImpl<ShipTypeMapper, ShipType> implements IShipTypeService {

    @Autowired
    private ShipTypeMapper shipTypeMapper;

    @Value("${group6.shipType.shipTypePageSize}")
    private int shipTypePageSize;
    @Override
    public Page<ShipType> all(Integer current) {
        Page<ShipType> page = new Page<>(current, shipTypePageSize);

        Page<ShipType> shipTypePage = shipTypeMapper.selectPage(page, null);
        return shipTypePage;

    }

    @Override
    public Page<ShipType> search(String keyword, Integer current){
        QueryWrapper<ShipType> shipTypeQueryWrapper = new QueryWrapper<>();
        shipTypeQueryWrapper.like("st_name", keyword);

        Page<ShipType> page = new Page<>(current, shipTypePageSize);

        Page<ShipType> shipTypePage = shipTypeMapper.selectPage(page, shipTypeQueryWrapper);
        return shipTypePage;
    }

    @Override
    public Page<ShipType> search2(ShipTypeSearchBody shipTypeSearchBody) {


        //从searchBody取到的页数
        Integer searchBodyCurrentPage = shipTypeSearchBody.getCurrentPage();
        //从searchBody取到的关键字
        String searchBodyShipTypeKeyword = shipTypeSearchBody.getShipTypeKeyword();

        QueryWrapper<ShipType> shipTypeQueryWrapper = new QueryWrapper<>();

        int current;

        if (searchBodyCurrentPage != null && searchBodyCurrentPage >0){
            current = searchBodyCurrentPage;
        } else {
            current = 1;
        }

        if(searchBodyShipTypeKeyword != null && !searchBodyShipTypeKeyword.equals("")){
            shipTypeQueryWrapper.like("st_name", searchBodyShipTypeKeyword);
        }


        Page<ShipType> page = new Page<>(current, shipTypePageSize);

        Page<ShipType> shipTypePage = shipTypeMapper.selectPage(page, shipTypeQueryWrapper);
        return shipTypePage;
    }
}
