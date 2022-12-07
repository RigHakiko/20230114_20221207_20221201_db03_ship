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
public class ShipImage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船只图片ID
     */
    @TableId(value = "si_id", type = IdType.AUTO)
    private Integer siId;

    /**
     * 船只图片URL
     */
    private String siUrl;


}
