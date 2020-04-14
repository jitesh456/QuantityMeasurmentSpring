package com.example.quantitymeasurment;

import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class QuantityMeasurementApplicationTests {

    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;


    @Test
    void contextLoads() {
    }

    @Test
    void testForGettingAllUnitType() {
        List<UnitType> actualList=new ArrayList<>();
        actualList.add(UnitType.TEMPERATURE);
        actualList.add(UnitType.LENGTH);
        actualList.add(UnitType.VOLUME);
        actualList.add(UnitType.WEIGHT);
        List<UnitType> expectedList = iQuantityMeasurementService.getAllUnitType();
        Assertions.assertEquals(actualList,expectedList);
    }
}
