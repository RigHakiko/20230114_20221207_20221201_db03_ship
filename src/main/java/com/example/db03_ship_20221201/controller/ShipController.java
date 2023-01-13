package com.example.db03_ship_20221201.controller;


import com.example.db03_ship_20221201.entity.Ship;
import com.example.db03_ship_20221201.result.ResultInfo;
import com.example.db03_ship_20221201.searchBody.ShipSearchBody;
import com.example.db03_ship_20221201.service.IShipImageService;
import com.example.db03_ship_20221201.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Ship ship) {

        Integer stID = ship.getStId();
        BigDecimal sRentprice = ship.getSRentprice();
        String sName = ship.getSName();
        String sNumber = ship.getSNumber();

        boolean flag = true;
        List<String> errorMessageItemList = new ArrayList<>();

        if (stID == null) {
            flag = false;
            errorMessageItemList.add("船只类型ID不存在");
        }


        if (sRentprice == null) {
            flag = false;
            errorMessageItemList.add("船只租赁价格不存在");
        }


        if (sName == null) {
            flag = false;
            errorMessageItemList.add("船只名称不存在或为空");
        }

        if (sNumber == null) {
            flag = false;
            errorMessageItemList.add("船只编号不存在");
        }

        if (flag) {
            return ResultInfo.success(iShipService.save(ship));
        }

        String errorMessage = String.join(";", errorMessageItemList);
//        boolean save = iShipService.save(ship);
//        return save;
        return ResultInfo.fail(errorMessage);
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResultInfo update(@RequestBody Ship ship) {

        Integer sId = ship.getSId();
        Integer stID = ship.getStId();
        BigDecimal sRentprice = ship.getSRentprice();
        String sName = ship.getSName();
        String sNumber = ship.getSNumber();

        boolean flag = true;
        List<String> errorMessageItemList = new ArrayList<>();

        if (sId == null) {
            flag = false;
            errorMessageItemList.add("船只ID不存在");
        }
        if (stID == null) {
            flag = false;
            errorMessageItemList.add("船只类型ID不存在");
        }


        if (sRentprice == null) {
            flag = false;
            errorMessageItemList.add("船只租赁价格不存在");
        }


        if (sName == null) {
            flag = false;
            errorMessageItemList.add("船只名称不存在或为空");
        }

        if (sNumber == null) {
            flag = false;
            errorMessageItemList.add("船只编号不存在");
        }

        if (flag) {
            return ResultInfo.success(iShipService.save(ship));
        }

        String errorMessage = String.join(";", errorMessageItemList);
        return ResultInfo.fail(errorMessage);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResultInfo delete(@PathVariable("id") Integer id) {
        boolean removed = iShipService.removeById(id);
        if (removed) {
            return ResultInfo.success(true);
        } else {
            return ResultInfo.fail("删除失败");
        }
    }

    @CrossOrigin
    @DeleteMapping("/deleteBatch")
    public ResultInfo deleteBatch(List<Integer> ids) {
        boolean removed = iShipService.removeByIds(ids);
        if (removed) {
            return ResultInfo.success(true);
        } else {
            return ResultInfo.fail("删除失败");
        }
    }

    @CrossOrigin
    @GetMapping("/selectOne/{id}")
    public ResultInfo selectOne(@PathVariable("id") Integer id) {
        Ship byId = iShipService.getById(id);
        if (byId == null) {
            return ResultInfo.fail("查找失败");
        } else {
            return ResultInfo.success(byId);
        }
    }

//    @GetMapping("/select")
//    @PostMapping("/select")
    @RequestMapping("/select")
    @CrossOrigin
    public ResultInfo select(@RequestBody ShipSearchBody shipSearchBody) {
        List<Ship> select = iShipService.select(shipSearchBody);
        if(select == null){
            return ResultInfo.fail("没有找到");
        } else {
            return ResultInfo.success(select);
        }
    }

//    @GetMapping("/counts")
//    @PostMapping("/counts")
    @RequestMapping("/counts")
    @CrossOrigin
    public ResultInfo counts(@RequestBody ShipSearchBody shipSearchBody) {
        Integer counts = iShipService.counts(shipSearchBody);
        if(counts == null){
            return ResultInfo.fail("查找失败");
        } else {
            return ResultInfo.success(counts);
        }
    }
}

