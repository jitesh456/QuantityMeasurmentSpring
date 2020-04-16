package com.example.quantitymeasurment.controller;

import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import com.example.quantitymeasurment.response.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;

    @GetMapping ("/allUnitType")
    public ResponseEntity<ResponseDto> getAllUnitType(){
        List<UnitType> allUnitType = iQuantityMeasurementService.getAllUnitType();
        ResponseDto responseDto=new ResponseDto(201,"Success",allUnitType);
        return new ResponseEntity<>(responseDto, HttpStatus.FOUND);
    }

    @GetMapping("/subUnit")
    public ResponseEntity<ResponseDto> getAllSubUnit(@RequestParam("UnitType")UnitType unitType) {
        List<Unit> subUnit = iQuantityMeasurementService.getSubUnit(unitType);
        ResponseDto responseDto=new ResponseDto(201,"Success",subUnit);
        return new ResponseEntity<>(responseDto, HttpStatus.FOUND);
    }

    @PostMapping("/convert")
    public ResponseEntity<ResponseDto> convert(@RequestBody UnitDao unitDao){

        double convert = iQuantityMeasurementService.convert(unitDao);
        ResponseDto responseDto=new ResponseDto(201,"Success",convert);
        return new ResponseEntity<>(responseDto, HttpStatus.FOUND);
    }
}
