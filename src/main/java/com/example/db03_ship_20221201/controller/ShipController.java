package com.example.db03_ship_20221201.controller;


import com.example.db03_ship_20221201.service.IShipImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    private IShipImageService iShipImageService;


}

