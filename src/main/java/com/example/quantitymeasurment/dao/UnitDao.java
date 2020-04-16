package com.example.quantitymeasurment.dao;

import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;

public class UnitDao {
    UnitType unitType;
    Unit inputUnit;
    Unit outputUnit;
    double initialValue;


    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Unit getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(Unit inputUnit) {
        this.inputUnit = inputUnit;
    }

    public Unit getOutputUnit() {
        return outputUnit;
    }

    public void setOutputUnit(Unit outputUnit) {
        this.outputUnit = outputUnit;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }
}
