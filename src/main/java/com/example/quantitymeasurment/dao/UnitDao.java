package com.example.quantitymeasurment.dao;

import com.example.quantitymeasurment.enumerations.UnitType;

public class UnitDao {
    UnitType unitType;

    public UnitDao(UnitType unitType) {
        this.unitType = unitType;
    }

    public UnitType getUnitType() {
        return unitType;
    }

}
