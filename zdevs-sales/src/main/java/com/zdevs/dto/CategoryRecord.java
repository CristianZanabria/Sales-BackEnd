package com.zdevs.dto;

public record CategoryRecord(
        int idCategory,
        String  nameCategory,
        String  descriptionCategory,
        boolean enabledCategory
) {
}

