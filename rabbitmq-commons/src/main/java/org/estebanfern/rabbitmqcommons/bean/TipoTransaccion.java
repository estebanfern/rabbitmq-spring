package org.estebanfern.rabbitmqcommons.bean;

public enum TipoTransaccion {

    COMPRA('C'),
    VENTA('V');

    private final Character value;

    TipoTransaccion(Character c) {
        this.value = c;
    }

    public Character getValue() {
        return value;
    }

    public TipoTransaccion fromValue(Character c) {
        for (TipoTransaccion tipo : TipoTransaccion.values()) {
            if (tipo.getValue().equals(c)) {
                return tipo;
            }
        }
        return null;
    }

}
