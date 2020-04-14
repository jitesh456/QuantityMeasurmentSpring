package com.example.quantitymeasurment.enumerations;

public enum Unit {
    INCH(1,UnitType.LENGTH),
    FEET(12,UnitType.LENGTH),
    YARD(36,UnitType.LENGTH),
    CENTIMETER(0.4,UnitType.LENGTH),
    GALLON(3780,UnitType.VOLUME),
    LITRE(1000,UnitType.VOLUME),
    MILLI_LITRE(1,UnitType.VOLUME),
    KILO_GRAMS(1000,UnitType.WEIGHT),
    GRAMS(1,UnitType.WEIGHT),
    TONNE(100000,UnitType.WEIGHT),
    FAHRENHEIT(1,UnitType.TEMPERATURE),
    CELSIUS(2.12,UnitType.TEMPERATURE);

    public final double baseUnit;
    public final UnitType unitType;

    Unit(double baseUnit, UnitType unitType) {
        this.baseUnit=baseUnit;
        this.unitType=unitType;
    }
}
