package org.estebanfern.rabbitmqcommons.dao.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DaoUtils {

    public static String getInsert(String table, String[] columns) {
        return "INSERT INTO " + table + " (" + String.join(", ", columns) +
                ") VALUES " + Arrays.stream(columns).map(c -> ":" + c).collect(Collectors.joining(", ", "(", ") "));
    }

    public static String getUpdateStock(String table, String column, Character signo) {
        return String.format("UPDATE %s SET %s = %s %s :value WHERE id = :id", table, column, column, signo);
    }

}
