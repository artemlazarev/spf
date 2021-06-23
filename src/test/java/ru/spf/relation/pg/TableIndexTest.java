package ru.spf.relation.pg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.spf.relation.service.CreateAndFillTableService;

import java.sql.SQLException;

//btree, hash, gist, gin
@SpringBootTest()
public class TableIndexTest {
    @Autowired
    CreateAndFillTableService service;

    private final int RECORDS_COUNT = 300_000;

    @BeforeEach
    public void init(){
        service.execSQL("DROP TABLE IF EXISTS no_indexes CASCADE");
        service.creaTetable();
    }

    @Test
    public void writeNoIndexes() throws InterruptedException {
        service.filTable(RECORDS_COUNT);
    }
    @Test
    public void writeWith1IntIndex() throws InterruptedException {
        service.execSQL("CREATE INDEX index2_idx ON no_indexes (index2)");
        service.filTable(RECORDS_COUNT);
    }
    @Test
    public void write1Int1TextIndex() throws InterruptedException {
        service.execSQL("CREATE INDEX index2_idx ON no_indexes (index2)");
        service.execSQL("CREATE INDEX index3_idx ON no_indexes (index3)");
        service.filTable(RECORDS_COUNT);
    }
    @Test
    public void integerIndexCreation() throws InterruptedException, SQLException {
        ;
    }

}
