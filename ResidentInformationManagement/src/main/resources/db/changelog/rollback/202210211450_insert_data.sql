DO
$$
    BEGIN
        DELETE FROM apartment_register WHERE id != '';
        DELETE FROM parking_register WHERE id != '';
        DELETE FROM parking_area WHERE id != '';
        DELETE FROM parking_type WHERE id > 0;
        DELETE FROM apartment WHERE id != '';
        DELETE FROM floor WHERE id != '';
        DELETE FROM building WHERE id != '';
        DELETE FROM project WHERE id != '';
        DELETE FROM customer WHERE id != '';
        DELETE FROM users WHERE id > 0;
        DELETE FROM role where code != '';
        DELETE FROM authority where code != '';
    END ;
$$;