package com.estebanfern.ventasms.dao;

import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dao.table.TransaccionTable;
import org.estebanfern.rabbitmqcommons.dao.utils.DaoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Objects;

@Repository
public class TransaccionDao extends NamedParameterJdbcDaoSupport {

    private static final Logger logger = LoggerFactory.getLogger(TransaccionDao.class);

    public TransaccionDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void save(Transaccion transaccion) {
        String insert = DaoUtils.getInsert(TransaccionTable.getTableName(), TransaccionTable.getInsertColumns());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tipo", transaccion.getTipo().getValue());
        params.addValue("cliente_id", transaccion.getClienteId());
        params.addValue("producto_id", transaccion.getProductoId());
        params.addValue("cantidad", transaccion.getCantidad());
        params.addValue("precio_total", transaccion.getPrecioTotal());
        logger.info("QUERY: {} \t PARAMS: {}", insert, params);
        final int result = Objects.requireNonNull(getNamedParameterJdbcTemplate()).update(insert, params);
        logger.info("Result -> {}", result);
    }

}
