package com.example.quantitymeasurment.controller;

import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;

    @GetMapping ("/allUnitType")
    public List getAllUnitType(){
        return iQuantityMeasurementService.getAllUnitType();
    }

    @GetMapping("/subUnit")
    public List<Unit> getAllSubUnit(@RequestParam("UnitType")UnitType unitType) {

        return iQuantityMeasurementService.getSubUnit(unitType);
    }
}
