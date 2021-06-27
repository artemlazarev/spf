package ru.spf.relation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.spf.relation.entity.BaseTable;
import ru.spf.relation.repository.TestTableRepository;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CreateAndFillTableService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final int PARALEL_COUNT = 32;

    @Autowired
    TestTableRepository repository;

    Callable<Integer> task(int start, int count, CountDownLatch latch){
        return () -> {
            int i = 0;
            try {
                BaseTable current = BaseTable.start(start);
                repository.save(current);
                for (i = start; i < start+count; i++) {
                    current = current.getNext();
                    repository.save(current);
                }
                System.out.println("Complete for interval started at: " + start);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                latch.countDown();
            }
                return i;
        };

    };

    public void filTable(int recordsCount) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(PARALEL_COUNT);
        CountDownLatch latch = new CountDownLatch(PARALEL_COUNT);
        int count = recordsCount / PARALEL_COUNT;
        for(int i =0; i< PARALEL_COUNT-1; i++){
            executor.submit(task(count*i, count, latch));
        }
        executor.submit(task((PARALEL_COUNT-1)*count, recordsCount - (PARALEL_COUNT-1)*count -1, latch));
        latch.await();
    }
    public void creaTetable() {
        jdbcTemplate.execute(BaseTable.DEF_SQL);
    }
    public void execSQL(String sql) {
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException th)
        {
            th.printStackTrace();
        }
    }
}
