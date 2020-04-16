package com.example.quantitymeasurment.enumerations;

public enum Unit {
    INCH(1,1,UnitType.LENGTH),
    FEET(12,0.83,UnitType.LENGTH),
    YARD(36,0.027,UnitType.LENGTH),
    CENTIMETER(0.4,2.54,UnitType.LENGTH),
    GALLON(3780,0.00026,UnitType.VOLUME),
    LITRE(1000,0.001,UnitType.VOLUME),
    MILLI_LITRE(1,1,UnitType.VOLUME),
    KILO_GRAMS(1000,0.001,UnitType.WEIGHT),
    GRAMS(1,1,UnitType.WEIGHT),
    TONNE(100000,0.000001,UnitType.WEIGHT),
    FAHRENHEIT(1,33.8,UnitType.TEMPERATURE),
    CELSIUS(1,1,UnitType.TEMPERATURE);

    public final double baseValue;
    public final double actualValue;
    public final UnitType unitType;

    Unit(double baseValue,double actualValue,UnitType unitType) {
        this.baseValue =baseValue;
        this.unitType=unitType;
        this.actualValue=actualValue;
    }

}
