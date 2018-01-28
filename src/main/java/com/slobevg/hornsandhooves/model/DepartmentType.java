package com.slobevg.hornsandhooves.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DepartmentType {

    CUSHIONED_FURNITURE(Collections.unmodifiableList(Arrays.asList(
            FurnitureType.BED,
            FurnitureType.ARMCHAIR,
            FurnitureType.SOFA
    ))),
    OFFICE_FURNITURE(Collections.unmodifiableList(Arrays.asList(
            FurnitureType.CUPBOARD,
            FurnitureType.CURBSTONE,
            FurnitureType.RACK
    ))),
    STORAGE_FURNITURE(Collections.unmodifiableList(Arrays.asList(
            FurnitureType.TABLE,
            FurnitureType.CHAIR,
            FurnitureType.ROCKING_CHAIR
    )));

    private final List<FurnitureType> furnitureTypes;

    DepartmentType(List<FurnitureType> furnitureTypes) {
        this.furnitureTypes = furnitureTypes;
    }

    public List<FurnitureType> getFurnitureTypes() {
        return furnitureTypes;
    }
}
