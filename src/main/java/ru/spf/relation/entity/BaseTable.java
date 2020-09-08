package ru.spf.relation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="no_indexes")
public class BaseTable {
    @Id
    @Column(name="Id")
    public Long id;

    @Column(name="index2")
    long index2;
    @Column(name="index3")
    String index3;

    @Column(name="value2")
    String value2;
    @Column(name="value3")
    String value3;

    public BaseTable(Long id, Long index2, String index3, String value2, String value3) {
        this.id = id;
        this.index2 = index2;
        this.index3 = index3;
        this.value2 = value2;
        this.value3 = value3;
    }

    public BaseTable(){}
    public BaseTable getNext(){
        long i = this.id/10;
        return new BaseTable(this.id+1, i, "text" + i, this.value2, this.value3);
    }

    public static BaseTable start(long start){
        return new BaseTable(start, start,"text","some litlle value",
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "+
                "some big value thiw some long text for storing repited some time. "
        );
    }
    public static String CRT_STM="CREATE TABLE IF NOT EXISTS no_indexes (\n" +
            "  \tid integer PRIMARY KEY,\n" +
            "  \tindex2 integer,\n" +
            "\tindex3 text,\n" +
            "\tvalue2 text,\n" +
            "\tvalue3 text\n" +
            ")";
}