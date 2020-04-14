package com.example.quantitymeasurment;

import com.example.quantitymeasurment.controller.QuantityMeasurementController;
import com.example.quantitymeasurment.exception.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class QuantityMeasurementApplicationTests {

    @Autowired
    QuantityMeasurementController quantityMeasurementController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() throws Exception{
        assertThat(quantityMeasurementController).isNotNull();
    }

    @Test
    public void getAllUnit_ShouldReturnAllUnit(){
        List<String> expectedUnitTypeList=new ArrayList<>();
        expectedUnitTypeList.add("LENGTH");
        expectedUnitTypeList.add("TEMPERATURE");
        expectedUnitTypeList.add( "WEIGHT");
        expectedUnitTypeList.add("VOLUME");
        assertThat(this.testRestTemplate.getForObject("http://localhost:"+port+"/allUnitType",List.class))
                .isEqualTo(expectedUnitTypeList);
    }

    @Test
    void givenUnitType_WhenProper_ShouldReturnAllSubUnit() {
        List<String> expectedSubUnitList=new ArrayList<>();
        expectedSubUnitList.add("INCH");
        expectedSubUnitList.add("FEET");
        expectedSubUnitList.add("YARD");
        expectedSubUnitList.add("CENTIMETER");
        assertThat(this.testRestTemplate.
                getForObject("http://localhost:"+port+"/subUnit?UnitType=LENGTH",List.class))
                .isEqualTo(expectedSubUnitList);

    }

}
