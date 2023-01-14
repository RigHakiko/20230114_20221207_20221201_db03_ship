package com.example.db03_ship_20221201;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.example.db03_ship_20221201.entity.ShipType;
import com.example.db03_ship_20221201.searchBody.ShipTypeSearchBody;
import com.example.db03_ship_20221201.service.IShipTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void generate(){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ZHY");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/20221127_november_boat_db03_ship");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.db03_ship_20221201");
        mpg.setPackageInfo(pc);



        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 写于父类中的公共字段


        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        mpg.execute();
    }

    @Autowired
    private IShipTypeService iShipTypeService;

    @Test
    public void addData(){
        for (int i = 0; i < 50; i++) {
            ShipType shipType = new ShipType();
            shipType.setStName("20221006_" + (i+1));
            iShipTypeService.save(shipType);
        }
    }

    @Test
    public void tmp1(){
        Page<ShipType> a = iShipTypeService.search("1", 1);
        System.out.println(a);
//        return a;
    }

    // 20221207: 12:09 测试search2方法
    @Test
    public void testSearch2Service(){
        ShipTypeSearchBody shipTypeSearchBody = new ShipTypeSearchBody();
        shipTypeSearchBody.setCurrentPage(1);
        shipTypeSearchBody.setShipTypeKeyword("3");
        Page<ShipType> shipTypePage = iShipTypeService.search2(shipTypeSearchBody);
        System.out.println(shipTypePage);

    }

    @Test
//    为了试试commit
    public void tmp20230114(){

    }

    @Test
    public void tmp20230114_try_sleep(){


    }
}
