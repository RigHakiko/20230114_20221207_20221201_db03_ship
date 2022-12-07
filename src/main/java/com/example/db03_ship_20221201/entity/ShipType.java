package com.example.db03_ship_20221201.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZHY
 * @since 2022-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShipType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船只类型ID
     */
    @TableId(value = "st_id", type = IdType.AUTO)
    private Integer stId;

    /**
     * 船只类型名称
     */
    private String stName;


}
