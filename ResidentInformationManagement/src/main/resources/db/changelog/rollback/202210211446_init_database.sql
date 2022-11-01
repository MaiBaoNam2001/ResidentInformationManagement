DO
$$
    BEGIN
        DROP TABLE IF EXISTS apartment_register CASCADE;
        DROP TABLE IF EXISTS parking_register CASCADE;
        DROP TABLE IF EXISTS role_authority CASCADE;
        DROP TABLE IF EXISTS parking_area CASCADE;
        DROP TABLE IF EXISTS parking_type CASCADE;
        DROP TABLE IF EXISTS apartment CASCADE;
        DROP TABLE IF EXISTS floor CASCADE;
        DROP TABLE IF EXISTS building CASCADE;
        DROP TABLE IF EXISTS project CASCADE;
        DROP TABLE IF EXISTS customer CASCADE;
        DROP TABLE IF EXISTS users CASCADE;
        DROP TABLE IF EXISTS role CASCADE;
        DROP TABLE IF EXISTS authority CASCADE;
    END;
$$;