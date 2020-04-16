package com.example.quantitymeasurment.service;


import com.example.quantitymeasurment.dao.UnitDao;
import com.example.quantitymeasurment.enumerations.Unit;
import com.example.quantitymeasurment.enumerations.UnitType;
import com.example.quantitymeasurment.implementation.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {


    public List<UnitType> getAllUnitType() {

        return Arrays.asList(UnitType.values());

    }

    @Override
    public List<Unit> getSubUnit(UnitType unitType) {
        List<Unit> units;
        UnitDao unitDao=new UnitDao();
        unitDao.setUnitType(unitType);
        return units = Arrays.asList(Unit.values()).stream()
                .filter(unit -> unit.unitType.equals(unitDao.getUnitType())).collect(Collectors.toList());
    }

    @Override
    public double convert(UnitDao unitDao) {
        double convertValue=(unitDao.getInitialValue()*unitDao.getInputUnit().baseValue)*unitDao.getOutputUnit().actualValue;
        return convertValue;
    }


}
