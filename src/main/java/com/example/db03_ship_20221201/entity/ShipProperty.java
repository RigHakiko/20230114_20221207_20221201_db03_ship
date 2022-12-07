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
public class ShipProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船只属性ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 船只ID
     */
    private Integer spId;

    /**
     * 船只类型属性ID
     */
    private Integer stpId;

    /**
     * 船只属性值
     */
    private String spValue;


}
