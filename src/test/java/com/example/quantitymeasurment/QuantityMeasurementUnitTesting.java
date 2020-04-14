package com.example.quantitymeasurment;


import com.example.quantitymeasurment.controller.QuantityMeasurementController;
import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import net.minidev.json.parser.ParseException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityMeasurementUnitTesting {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IQuantityMeasurementService iQuantityMeasurementService;


    @Test
    public void shouldReturnAllUnitType() throws Exception {
        String expectedList = Arrays.toString(UnitType.values());
        List<UnitType> actualList = Arrays.asList(UnitType.values());
        given(iQuantityMeasurementService.getAllUnitType()).willReturn(actualList);
        mockMvc.perform(get("/allUnitType")).andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedList));
    }

    @Test
    public void givenUnitType_WhenProper_returnSubUnit() throws Exception {

        List<Unit> units=new ArrayList<>();
        units.add(Unit.INCH);
        units.add(Unit.YARD);
        units.add(Unit.FEET);
        units.add(Unit.CENTIMETER);
        Unit[] units1={Unit.INCH,Unit.YARD,Unit.FEET,Unit.CENTIMETER};
        given(iQuantityMeasurementService.getSubUnit(UnitType.LENGTH)).willReturn(units);
        String expectedList = Arrays.toString(units1);
        mockMvc.perform(get("/subUnit?UnitType=LENGTH")).andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedList));

    }

}
