package com.example.db03_ship_20221201.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.db03_ship_20221201.entity.ShipType;
import com.example.db03_ship_20221201.service.IShipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
@RestController
@RequestMapping("/ship-type")
public class ShipTypeController {

    @Autowired
    private IShipTypeService iShipTypeService;

    @GetMapping("/all/{current}")
    @CrossOrigin
    public Page<ShipType> all(@PathVariable("current") Integer current){
        return iShipTypeService.all(current);
    }

    @GetMapping("/find/{shipTypeId}")
    @CrossOrigin
    public ShipType find(@PathVariable("shipTypeId") Integer shipTypeId){
        ShipType byId = iShipTypeService.getById(shipTypeId);
        return byId;

    }

    @PostMapping("/add")
    @CrossOrigin
//    @ResponseBody
    public Boolean send(@RequestBody ShipType shipType){
        boolean save = iShipTypeService.save(shipType);
        return save;
    }

    @PutMapping("/edit")
    @CrossOrigin
    public Boolean edit(@RequestBody ShipType shipType){
        boolean b = iShipTypeService.updateById(shipType);
        return b;
    }

    @DeleteMapping("/del/{shipTypeId}")
    @CrossOrigin
    public Boolean delete(@PathVariable("shipTypeId") Integer shipTypeId){
        boolean b = iShipTypeService.removeById(shipTypeId);
        return b;
    }

//    current 为当前页
    @GetMapping("/search/{current}/{keyword}")
    @CrossOrigin
    public Page<ShipType> search(@PathVariable("keyword") String keyword, @PathVariable("current") Integer current){

        Page<ShipType> page = iShipTypeService.search(keyword, current);
        return page;
    }

    
}

