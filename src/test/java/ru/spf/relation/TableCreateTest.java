package ru.spf.relation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.spf.relation.service.TableCreateTestService;

import java.sql.SQLException;

@SpringBootTest()
public class TableCreateTest {
    @Autowired
    TableCreateTestService service;

    private final int RECORDS_COUNT = 30;

    @BeforeEach
    public void init(){
        service.execSQL("delete from no_indexes");
    }

    @Test
    @Order(1)
    public void filTableTestNoIndexes() throws InterruptedException {
        service.filTable(RECORDS_COUNT);
    }
    @Test
    @Order(2)
    public void filTableTestWith1IntIndex() throws InterruptedException {
        service.execSQL("DROP INDEX index2_idx");
        service.execSQL("CREATE INDEX index2_idx ON no_indexes (index2)");
        service.filTable(RECORDS_COUNT);
    }
    @Test
    @Order(1)
    public void integerIndexCreation() throws InterruptedException, SQLException {
        ;
    }

}
