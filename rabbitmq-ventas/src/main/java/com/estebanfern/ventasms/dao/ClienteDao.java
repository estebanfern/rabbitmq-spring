package com.estebanfern.ventasms.dao;

import org.estebanfern.rabbitmqcommons.bean.Cliente;
import org.estebanfern.rabbitmqcommons.dao.table.ClienteTable;
import org.estebanfern.rabbitmqcommons.dao.utils.DaoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Objects;

@Repository
public class ClienteDao extends NamedParameterJdbcDaoSupport {

    private static final Logger logger = LoggerFactory.getLogger(ClienteDao.class);

    public ClienteDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void save(Cliente cliente) {
        String insert = DaoUtils.getInsert(ClienteTable.getTableName(), ClienteTable.getInsertColumns());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", cliente.getNombre());
        params.addValue("correo", cliente.getCorreo());
        params.addValue("direccion", cliente.getDireccion());
        logger.info("QUERY: {} \t PARAMS: {}", insert, params);
        final int result = Objects.requireNonNull(getNamedParameterJdbcTemplate()).update(insert, params);
        logger.info("Result -> {}", result);
    }

}
