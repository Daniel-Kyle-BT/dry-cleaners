
INSERT INTO codigo_secuencia (prefijo, ultimo_valor)
SELECT *
FROM (
    SELECT 'CLI', 0
    UNION ALL
    SELECT 'EMP', 0
) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM codigo_secuencia LIMIT 1
);