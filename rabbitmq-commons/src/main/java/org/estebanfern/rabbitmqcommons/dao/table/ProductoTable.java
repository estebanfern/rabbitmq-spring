package org.estebanfern.rabbitmqcommons.dao.table;

import java.util.Arrays;

public class ProductoTable {

    private final static String TABLE_NAME = "productos";

    private final static String[] COLUMNS = {
        "id",
        "nombre",
        "descripcion",
        "precio",
        "stock",
    };

    public static String[] getColumns() {
        return COLUMNS;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String[] getInsertColumns() {
        return Arrays.stream(COLUMNS).filter(
                column -> !(column.equals("id") || column.equals("stock"))
        ).toArray(String[]::new);
    }

}
