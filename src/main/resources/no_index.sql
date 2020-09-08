
SELECT * FROM no_indexes order by id;

SELECT pg_size_pretty( pg_total_relation_size('no_indexes') );
