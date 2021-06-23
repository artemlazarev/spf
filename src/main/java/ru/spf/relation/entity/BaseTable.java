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
    public static String DEF_SQL = "CREATE TABLE no_indexes(id serial PRIMARY KEY, index2 integer, index3 VARCHAR(255), value2 VARCHAR(255), value3 VARCHAR(10000));";

    public static BaseTable start(long start){
        return new BaseTable(start, start,"text","some little text value",
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "+
                "some long text value with  some text, repited some time. "
        );
    }
}