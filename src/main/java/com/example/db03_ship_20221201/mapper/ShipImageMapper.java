package com.example.db03_ship_20221201.mapper;

import com.example.db03_ship_20221201.entity.ShipImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
@Repository
@MapperScan
public interface ShipImageMapper extends BaseMapper<ShipImage> {

}
