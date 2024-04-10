package com.estebanfern.productosms.dao;

import org.estebanfern.rabbitmqcommons.bean.Producto;
import org.estebanfern.rabbitmqcommons.bean.TipoTransaccion;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dao.table.ProductoTable;
import org.estebanfern.rabbitmqcommons.dao.utils.DaoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Objects;

@Repository
public class ProductoDao extends NamedParameterJdbcDaoSupport {

    private static final Logger logger = LoggerFactory.getLogger(ProductoDao.class);

    public ProductoDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void save(Producto producto) {
        String insert = DaoUtils.getInsert(ProductoTable.getTableName(), ProductoTable.getInsertColumns());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", producto.getNombre());
        params.addValue("descripcion", producto.getDescripcion());
        params.addValue("precio", producto.getPrecio());
        logger.info("QUERY: {} \t PARAMS: {}", insert, params);
        final int result = Objects.requireNonNull(getNamedParameterJdbcTemplate()).update(insert, params);
        logger.info("Result -> {}", result);
    }

    public void updateStock(Transaccion transaccion) {
        Character signo = transaccion.getTipo().equals(TipoTransaccion.COMPRA) ? '+' : '-';
        String update = DaoUtils.getUpdateStock(ProductoTable.getTableName(), "stock", signo);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", transaccion.getProductoId());
        params.addValue("value", transaccion.getCantidad());
        logger.info("QUERY: {} \t PARAMS: {}", update, params);
        final int result = Objects.requireNonNull(getNamedParameterJdbcTemplate()).update(update, params);
        logger.info("Result -> {}", result);
    }

}
