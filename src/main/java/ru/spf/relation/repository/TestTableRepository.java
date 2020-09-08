package ru.spf.relation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spf.relation.entity.BaseTable;


@Repository
public interface TestTableRepository extends CrudRepository<BaseTable, Long> {

}
