# Jakarta EE: mejoras de rendimiento

## Servidor de aplicaciones

Ejemplos para: Apache Tomcat / Apache TomEE.

Posibles optimizaciones en el archivo ``server.xml``:

```xml 

 <Connector port="8088" protocol="HTTP/1.1"
	   connectionTimeout="20000"
	   redirectPort="8443"
	   enableLookups="false"
	   compression="off"
	   acceptCount="2048"
	   maxConnections="1024"
	   maxThreads="1000"
	   tcpNoDelay="true"/>

```

Crear archivo ``setenv.sh`` dentro del directorio donde está ``catalina.sh``: 

```bash
CATALINA_OPTS=" -Xms1024m -Xmx5012m -XX:PermSize=2048m -XX:MaxPermSize=2048m -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
```

## Servidor web

Tanto **Nginx** como **Apache web server** se pueden optimizar instalando el módulo [PageSpeed](https://www.modpagespeed.com/doc/).

```
ModPagespeedModifyCachingHeaders off
ModPagespeedXHeaderValue "*"
ModPagespeedEnableFilters lazyload_images
ModPagespeedEnableFilters collapse_whitespace
ModPagespeedEnableFilters dedup_inlined_images
ModPagespeedEnableFilters defer_javascript
ModPagespeedEnableFilters elide_attributes
ModPagespeedEnableFilters convert_gif_to_png
ModPagespeedEnableFilters inline_images
ModPagespeedEnableFilters hint_preload_subresources
ModPagespeedEnableFilters remove_comments
ModPagespeedEnableFilters insert_dns_prefetch
ModPagespeedEnableFilters remove_quotes
ModPagespeedEnableFilters rewrite_css

ModPagespeedEnableFilters inline_css
ModPagespeedEnableFilters prioritize_critical_css
ModPagespeedEnableFilters trim_urls
ModPagespeedEnableFilters inline_javascript
ModPagespeedRewriteLevel OptimizeForBandwidth
ModPagespeedEnableFilters combine_css
ModPagespeedEnableFilters combine_javascript
ModPagespeedEnableFilters combine_heads
ModPagespeedEnableFilters rewrite_javascript

```

## Base de datos

Ejemplos sobre PostgreSQL.

### Configuración

Mejorar el rendimiento de base de datos PosgtreSQL modificando el archivo de configuración (C:/Program Files/PostgreSQL/13/data/postgresql.conf):

```conf
max_connections = 20
shared_buffers = 8GB
effective_cache_size = 24GB
maintenance_work_mem = 2GB
checkpoint_completion_target = 0.9
wal_buffers = 16MB
default_statistics_target = 100
random_page_cost = 1.1
effective_io_concurrency = 200
work_mem = 104857kB
min_wal_size = 1GB
max_wal_size = 4GB
max_worker_processes = 8
max_parallel_workers_per_gather = 4
max_parallel_workers = 8
max_parallel_maintenance_workers = 4
```

Se utiliza el programa [pgtune](https://pgtune.leopard.in.ua/#/), ejemplo de uso: 

```bash
pgtune -i C:/Program Files/PostgreSQL/13/data/postgresql.conf/postgresql.conf -o C:/Program Files/PostgreSQL/13/data/postgresql.conf.pgtune
```


### Índices

Un índice es una estructura de datos separada que permite optimizar la recuperación de datos

```sql

-- Crear índices:

CREATE INDEX index_name ON table_name(col1, col2);

CREATE INDEX access_log_client_ip_ix ON access_log (client_ip)
WHERE NOT (client_ip > inet '192.168.100.0' AND
client_ip < inet '192.168.100.255');


-- ver índices de una tabla :

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
    tablename = 'my_table';


-- Ver índices en desuso: 

SELECT
  relname                                               AS TableName,
  to_char(seq_scan, '999,999,999,999')                  AS TotalSeqScan,
  to_char(idx_scan, '999,999,999,999')                  AS TotalIndexScan,
  to_char(n_live_tup, '999,999,999,999')                AS TableRows,
  pg_size_pretty(pg_relation_size(relname :: regclass)) AS TableSize
FROM pg_stat_all_tables
WHERE schemaname = 'public'
      AND 50 * seq_scan > idx_scan -- more than 2%
      AND n_live_tup > 10000
      AND pg_relation_size(relname :: regclass) > 5000000
ORDER BY relname ASC;

```

Tipos de índices:
* Single column
* Multi column
* Unique
* Partial (Cuando se aplican predicados, WHERE)
* Implicit (el que se crea por defecto sobre la pk)

### Query Plan

Uso de EXPLAIN ANALYZE para detectar índices mal usados y tiempos de ejecución lentos:

```sql

-- Ejemplo:
EXPLAIN ANALYZE SELECT * FROM credit_cards;

-- Formatos de salida:
explain (format json) select * from measurement;
explain (format yaml) select * from measurement;
explain (format xml) select * from measurement;
explain (format text) select * from measurement;

```

### VACUUM

```sql

VACUUM table_name;
VACUUM ANALYZE table_name;
VACUUM FULL table_name;
VACUUM VERBOSE table_name;

```

### Particionamiento

```sql
-- 1. Rango

drop table if exists employees;

CREATE TABLE employees(
    id BIGSERIAL,
    birth_date DATE NOT NULL,
	first_name varchar(20) NOT null,
    primary KEY(id, birth_date)
) PARTITION BY RANGE (birth_date);


CREATE TABLE employees_2019 PARTITION OF employees
FOR VALUES FROM ('2019-01-01') TO ('2020-01-01');
-- from inclusive
-- to exclusive

CREATE TABLE employees_2020 PARTITION OF employees
FOR VALUES FROM ('2020-01-01') TO ('2021-01-01');

CREATE TABLE employees_2021 PARTITION OF employees
FOR VALUES FROM ('2021-01-01') TO ('2022-01-01');

INSERT INTO employees(birth_date, first_name) values
('2019-02-14', 'Employee 1'),
('2020-06-14', 'Employee 2'),
('2021-07-14', 'Employee 3');

SELECT * from employees;
SELECT * from ONLY employees;
SELECT * from employees_2019;
SELECT * from employees_2020;
SELECT * from employees_2021;

INSERT INTO employees(birth_date, first_name) values
('2022-01-14', 'Employee 4');

INSERT INTO employees(birth_date, first_name) values
('2020-06-17', 'Employee 5');

EXPLAIN ANALYZE select * from employees;

EXPLAIN ANALYZE select * from employees where first_name = 'Employee 3';

EXPLAIN ANALYZE select * from employees where birth_date = '2020-06-14';

EXPLAIN ANALYZE select * from employees where EXTRACT(month FROM birth_date) = 6 and EXTRACT(year FROM birth_date) = 2020;

EXPLAIN ANALYZE select * from employees where birth_date > '2020-06-01';

-- 2. Lista

drop table if exists employees;
CREATE TABLE employees(
    id BIGSERIAL,
    birth_date DATE NOT NULL,
    first_name varchar(20) NOT null,
    country_code varchar(2) NOT NULL,
    primary KEY(id, country_code)
) PARTITION BY LIST (country_code);

CREATE TABLE employees_co_1 PARTITION OF employees FOR VALUES IN ('ES', 'FR', 'DE');

CREATE TABLE employees_co_2 PARTITION OF employees FOR VALUES IN ('AT', 'NZ', 'CA');

INSERT INTO employees(birth_date, first_name, country_code) values
('2019-02-14', 'Employee 1', 'ES'),
('2020-06-14', 'Employee 2', 'FR' ),
('2021-07-14', 'Employee 3', 'NZ');

EXPLAIN ANALYZE select * from employees ;
EXPLAIN ANALYZE select * from employees where country_code = 'ES';

INSERT INTO employees(birth_date, first_name, country_code) values
('2019-02-14', 'Employee 1', 'ZW');

-- 3. Hash

drop table if exists dept;

CREATE TABLE dept (
    id int primary key
) PARTITION BY HASH(id);

CREATE TABLE dept_hash1 PARTITION OF dept FOR VALUES WITH (MODULUS 3, REMAINDER 0);

CREATE TABLE dept_hash2 PARTITION OF dept FOR VALUES WITH (MODULUS 3, REMAINDER 1);

CREATE TABLE dept_hash3 PARTITION OF dept FOR VALUES WITH (MODULUS 3, REMAINDER 2);


INSERT INTO dept (
    SELECT generate_series(0, 200000)
);

EXPLAIN ANALYZE select * from dept;

select count(*) from dept_hash1;
select count(*) from dept_hash2;
select count(*) from dept_hash3;
select * from dept_hash2;
select * from dept_hash3;
EXPLAIN ANALYZE select * from dept where id = 3;
EXPLAIN ANALYZE select * from dept where id = 1258;
```


### reindexdb

Reconstruir los índices ayuda a optimizarlos:

```bash
reindexdb -U postgres --verbose postgres

reindexdb -U postgres --table=foo --index=bar postgres

```


## Persistencia con JPA

El uso de la API Jakarta Persistence (JPA) también se puede optimizar para mejorar la interacción con la base de datos:

1. Buscar consultas lentas: 

```xml
<property name="hibernate.session.events.log.LOG_QUERIES_SLOWER_THAN_MS" value="1"/>
```

2. Deshabilitar show_sql true en producción y debuggers.
3. Utilizar FetchType.LAZY en las asociaciones para evitar cargar datos innecesarios
	1. Por defecto todas las asociaciones pueden ser lazy y para recuperar dichos datos se pueden crear consultas separadas para usarlas solo cuando sea necesario
	2. Uso de join fetch
	3. Uso de EntityGraph
4. Evitar asociaciones ManyToMany, en caso de necesitarlas entonces realizarlas con Set en vez de con List.
5. Uso de caché
	1. Hibernate caché de 1 nivel
	2. Hibernate caché de 2 nivel
	3. EhCache
	4. Caffeine
	5. HazelCast
	6. Infinispan
	7. Memcached
	8. Redis
6. Guardar múltiples entidades a la vez en lugar de por separado en las operaciones de escritura a base de datos
7. Utilizar proyecciones y DTOs en las consultas en lugar de entidades puede optimizarlas bastante

## Tests de rendimiento

Medición del rendimiento con **Apache JMeter**, crear un test y ejecutarlo a través de consola:

```
jmeter -n -t example1.jmx -l example1-results.csv
```

Otras herramientas: 
* [Gatling](https://gatling.io/)
* [Netdata](https://github.com/netdata/netdata)
* [NewRelic](https://newrelic.com/)
* [Datadog](https://www.datadoghq.com/)