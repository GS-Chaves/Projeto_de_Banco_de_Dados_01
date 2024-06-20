package com.curriculo.api.curriculo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;

@RestController
public class DatabaseController {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/drop-all-tables")
    public String dropAllTables() {
        String sqlDropTables = "DO $$ " +
                "DECLARE " +
                "    r RECORD; " +
                "BEGIN " +
                "    EXECUTE 'SET session_replication_role = replica'; " +
                "    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') LOOP " +
                "        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE'; " +
                "    END LOOP; " +
                "    EXECUTE 'SET session_replication_role = DEFAULT'; " +
                "END $$;";

        jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
            try (PreparedStatement ps = connection.prepareStatement(sqlDropTables)) {
                ps.execute();
                return null;
            }
        });
        return "Todas as tabelas foram deletadas, reinicie a aplicação.";
    }
}
