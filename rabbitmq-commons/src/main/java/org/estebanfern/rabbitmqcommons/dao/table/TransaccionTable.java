package org.estebanfern.rabbitmqcommons.dao.table;

import java.util.Arrays;

public class TransaccionTable {

    private final static String TABLE_NAME = "transacciones";

    private final static String[] COLUMNS = {
        "id",
        "tipo",
        "fecha",
        "cliente_id",
        "producto_id",
        "cantidad",
        "precio_total",
    };

    public static String[] getColumns() {
        return COLUMNS;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String[] getInsertColumns() {
        return Arrays.stream(COLUMNS).filter(
                column -> !(column.equals("id") || column.equals("fecha"))
        ).toArray(String[]::new);
    }

}
