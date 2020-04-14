package com.example.quantitymeasurment.controller;

import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import com.example.quantitymeasurment.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;
    @RequestMapping("/allUnitType")
    public List getAllUnitType(){
        return iQuantityMeasurementService.getAllUnitType();
    }
}
