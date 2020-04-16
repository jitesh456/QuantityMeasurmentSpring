package com.example.quantitymeasurment;


import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import com.example.quantitymeasurment.response.ResponseDto;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityMeasurementUnitTesting {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IQuantityMeasurementService iQuantityMeasurementService;
    JSONObject dtoObject;
    HttpHeaders headers;
    UnitDao unitDao=new UnitDao();

    @BeforeEach
    void setUp() throws JSONException {
        headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        dtoObject=new JSONObject();

    }

    @Test
    public void shouldReturnAllUnitType() throws Exception {
        List<UnitType> actualList = Arrays.asList(UnitType.values());
        ResponseDto responseDto=new ResponseDto(201,"Success",actualList);
        Gson gson=new Gson();
        String responseDtoString = gson.toJson(responseDto);
        given(iQuantityMeasurementService.getAllUnitType()).willReturn(actualList);
        mockMvc.perform(get("/allUnitType")).andDo(print())
                .andExpect(content().json(responseDtoString));

    }

    @Test
    public void givenUnitType_WhenProper_returnSubUnit() throws Exception {

        List<Unit> units=new ArrayList<>();
        units.add(Unit.INCH);
        units.add(Unit.YARD);
        units.add(Unit.FEET);
        units.add(Unit.CENTIMETER);
        ResponseDto responseDto=new ResponseDto(201,"Success",units);
        Gson gson=new Gson();
        String responseDtoString = gson.toJson(responseDto);
        given(iQuantityMeasurementService.getSubUnit(UnitType.LENGTH)).willReturn(units);
        mockMvc.perform(get("/subUnit?UnitType=LENGTH")).andExpect(content().json(responseDtoString));

    }

    @Test
    public void givenQuantityData_WhenProper_ShouldReturnValue() throws Exception {
        ResponseDto responseDto=new ResponseDto(201,"Success",0.83);
        Gson gson=new Gson();
        String responseDtoString = gson.toJson(responseDto);
        given(iQuantityMeasurementService.convert(any())).willReturn(0.83);

        mockMvc.perform(post("/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(dtoObject)))
                .andExpect(content().json(responseDtoString));
    }
}
