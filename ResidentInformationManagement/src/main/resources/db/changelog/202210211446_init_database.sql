DO
$$
    BEGIN
        CREATE TABLE IF NOT EXISTS project
        (
            id   TEXT PRIMARY KEY,
            name TEXT,
            area TEXT
        );

        CREATE TABLE IF NOT EXISTS building
        (
            id         TEXT PRIMARY KEY,
            name       TEXT,
            project_id TEXT
        );

        ALTER TABLE building
            ADD FOREIGN KEY (project_id) REFERENCES project (id);

        CREATE TABLE IF NOT EXISTS floor
        (
            id          TEXT PRIMARY KEY,
            number      INT,
            building_id TEXT
        );

        ALTER TABLE floor
            ADD FOREIGN KEY (building_id) REFERENCES building (id);

        CREATE TABLE IF NOT EXISTS apartment
        (
            id       TEXT PRIMARY KEY,
            name     TEXT,
            floor_id TEXT
        );

        ALTER TABLE apartment
            ADD FOREIGN KEY (floor_id) REFERENCES floor (id);

        CREATE TABLE IF NOT EXISTS customer
        (
            id            TEXT PRIMARY KEY,
            name          TEXT,
            date_of_birth DATE,
            gender        TEXT,
            phone         TEXT UNIQUE,
            email         TEXT UNIQUE,
            address       TEXT,
            type          TEXT,
            identity_card TEXT
        );

        CREATE TABLE IF NOT EXISTS apartment_register
        (
            id             TEXT PRIMARY KEY,
            customer_id    TEXT,
            apartment_id   TEXT,
            is_host        BOOLEAN,
            resident_card  JSONB,
            motorbike_card JSONB,
            car_card       JSONB,
            register_date  DATE
        );

        ALTER TABLE apartment_register
            ADD FOREIGN KEY (customer_id) REFERENCES customer (id);
        ALTER TABLE apartment_register
            ADD FOREIGN KEY (apartment_id) REFERENCES apartment (id);

        CREATE TABLE IF NOT EXISTS parking_area
        (
            id          TEXT PRIMARY KEY,
            name        TEXT,
            building_id TEXT UNIQUE
        );

        ALTER TABLE parking_area
            ADD FOREIGN KEY (building_id) REFERENCES building (id);

        CREATE TABLE IF NOT EXISTS parking_type
        (
            id    BIGSERIAL PRIMARY KEY,
            name  TEXT,
            price DOUBLE PRECISION,
            unit  TEXT
        );

        CREATE TABLE IF NOT EXISTS parking_register
        (
            id              TEXT PRIMARY KEY,
            customer_id     TEXT,
            parking_area_id TEXT,
            license_plate   TEXT UNIQUE,
            brand_name      TEXT,
            color           TEXT,
            vehicle_type    TEXT,
            register_date   DATE,
            parking_type_id INT
        );

        ALTER TABLE parking_register
            ADD FOREIGN KEY (customer_id) REFERENCES customer (id);
        ALTER TABLE parking_register
            ADD FOREIGN KEY (parking_area_id) REFERENCES parking_area (id);
        ALTER TABLE parking_register
            ADD FOREIGN KEY (parking_type_id) REFERENCES parking_type (id);

        CREATE TABLE IF NOT EXISTS role
        (
            code TEXT PRIMARY KEY,
            name TEXT UNIQUE
        );

        CREATE TABLE IF NOT EXISTS authority
        (
            code    TEXT PRIMARY KEY,
            name    TEXT UNIQUE,
            options JSONB
        );

        CREATE TABLE IF NOT EXISTS role_authority
        (
            id             TEXT PRIMARY KEY,
            role_code      TEXT,
            authority_code TEXT
        );

        ALTER TABLE role_authority
            ADD FOREIGN KEY (role_code) REFERENCES ROLE (code);
        ALTER TABLE role_authority
            ADD FOREIGN KEY (authority_code) REFERENCES authority (code);

        CREATE TABLE IF NOT EXISTS users
        (
            id        BIGSERIAL PRIMARY KEY,
            username  TEXT UNIQUE,
            phone     TEXT UNIQUE,
            email     TEXT,
            password  TEXT,
            role_code TEXT
        );

        ALTER TABLE users
            ADD FOREIGN KEY (role_code) REFERENCES role (code);
    END;
$$;