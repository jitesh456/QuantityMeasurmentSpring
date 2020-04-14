package com.example.quantitymeasurment.service;


import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {


    public List<UnitType> getAllUnitType() {
        List<UnitType> unitTypes=new ArrayList<>();
        unitTypes.add(UnitType.TEMPERATURE);
        unitTypes.add(UnitType.LENGTH);
        unitTypes.add(UnitType.VOLUME);
        unitTypes.add(UnitType.WEIGHT);
        return unitTypes;
    }
}
