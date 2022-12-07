package com.example.db03_ship_20221201.entity;

import java.math.BigDecimal;
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
public class Ship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船只ID
     */
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    /**
     * 船只类型ID
     */
    private Integer stId;

    /**
     * 船只的主logo, 可以为空
     */
    private Integer siMainLogoId;

    /**
     * 船只租赁价格, 艘/小时
     */
    private BigDecimal sRentprice;

    /**
     * 船只名称
     */
    private String sName;

    /**
     * 船只编号
     */
    private String sNumber;

    /**
     * 船只配套产品
     */
    private String sProduct;

    /**
     * 船只详细信息
     */
    private String sDetail;

    /**
     * 船只故事
     */
    private String sStory;


}
