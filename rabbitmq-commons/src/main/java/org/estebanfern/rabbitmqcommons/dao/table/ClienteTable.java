package org.estebanfern.rabbitmqcommons.dao.table;

import java.util.Arrays;

public class ClienteTable {

    private final static String TABLE_NAME = "clientes";

    private final static String[] COLUMNS = {
        "id",
        "nombre",
        "correo",
        "direccion",
    };

    public static String[] getColumns() {
        return COLUMNS;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String[] getInsertColumns() {
        return Arrays.stream(COLUMNS).filter(
                column -> !(column.equals("id"))
        ).toArray(String[]::new);
    }

}
