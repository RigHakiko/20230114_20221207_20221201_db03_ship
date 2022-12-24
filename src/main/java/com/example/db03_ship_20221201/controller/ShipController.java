package com.example.db03_ship_20221201.controller;


import com.example.db03_ship_20221201.entity.Ship;
import com.example.db03_ship_20221201.result.ResultInfo;
import com.example.db03_ship_20221201.service.IShipImageService;
import com.example.db03_ship_20221201.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
@RestController
@RequestMapping("/ship")
public class ShipController {

    @Autowired
//    private IShipImageService iShipImageService;
    private IShipService iShipService;

    public ResultInfo insert(Ship ship){

        Integer stID = ship.getStId();
        BigDecimal sRentprice = ship.getSRentprice();
        String sName = ship.getSName();
        String sNumber = ship.getSNumber();

        boolean flag = true;
        List<String> errorMessageItemList = new ArrayList<>();

        if(stID == null){
            flag = false;
            errorMessageItemList.add("船只类型ID不存在");
        }


        if( sRentprice == null){
            flag = false;
            errorMessageItemList.add("船只租赁价格不存在");
        }


        if(sName == null){
            flag = false;
            errorMessageItemList.add("船只名称不存在或为空");
        }

        if(sNumber == null){
            flag = false;
            errorMessageItemList.add("船只编号不存在");
        }

        if(flag){
            return ResultInfo.success(iShipService.save(ship));
        }

        String errorMessage = String.join(";",errorMessageItemList ) ;
//        boolean save = iShipService.save(ship);
//        return save;
        return ResultInfo.fail(errorMessage);
    }

    public ResultInfo update(Ship ship){

        Integer sId = ship.getSId();
        Integer stID = ship.getStId();
        BigDecimal sRentprice = ship.getSRentprice();
        String sName = ship.getSName();
        String sNumber = ship.getSNumber();

        boolean flag = true;
        List<String> errorMessageItemList = new ArrayList<>();

        if(sId == null){
            flag = false;
            errorMessageItemList.add("船只ID不存在");
        }
        if(stID == null){
            flag = false;
            errorMessageItemList.add("船只类型ID不存在");
        }


        if( sRentprice == null){
            flag = false;
            errorMessageItemList.add("船只租赁价格不存在");
        }


        if(sName == null){
            flag = false;
            errorMessageItemList.add("船只名称不存在或为空");
        }

        if(sNumber == null){
            flag = false;
            errorMessageItemList.add("船只编号不存在");
        }

        if(flag){
            return ResultInfo.success(iShipService.save(ship));
        }

        String errorMessage = String.join(";",errorMessageItemList ) ;
        return ResultInfo.fail(errorMessage);
    }
}

