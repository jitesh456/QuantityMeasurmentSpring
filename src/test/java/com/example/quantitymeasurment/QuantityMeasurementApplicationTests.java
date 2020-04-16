package com.example.quantitymeasurment;

import com.example.quantitymeasurment.controller.QuantityMeasurementController;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class QuantityMeasurementApplicationTests {

    @Autowired
    QuantityMeasurementController quantityMeasurementController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;
    String convertUrl;
    JSONObject dtoObject;
    HttpHeaders headers;
    @Test
    void contextLoads() throws Exception{
        assertThat(quantityMeasurementController).isNotNull();
    }

    @BeforeEach
    void setUp() throws JSONException {
        convertUrl="http://localhost:8080/convert";
        headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        dtoObject=new JSONObject();
        dtoObject.put("unitType",UnitType.LENGTH);
        dtoObject.put("inputUnit",Unit.INCH);
        dtoObject.put("outputUnit",Unit.FEET);
        dtoObject.put("initialValue",1.0);

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

    @Test
    void givenQuantityMeasurementData_WhenProper_ReturnConvertedValue() {
        HttpEntity<String> request =
                new HttpEntity<>(dtoObject.toString(), headers);
        assertThat(this.testRestTemplate.
                postForObject(convertUrl, request, String.class)).isEqualTo("0.83");
    }
}
