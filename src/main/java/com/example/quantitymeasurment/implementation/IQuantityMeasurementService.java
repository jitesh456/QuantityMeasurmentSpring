package com.example.quantitymeasurment.implementation;

import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;

import java.util.List;

public interface IQuantityMeasurementService {
    List<UnitType> getAllUnitType();

    List<Unit> getSubUnit(UnitType unitType);

    double convert(UnitDao unitDao);
}
