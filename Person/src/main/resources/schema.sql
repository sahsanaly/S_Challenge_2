CREATE TABLE IF NOT EXISTS person (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    postcode varchar(255) NOT NULL,
    age varchar(255) NOT NULL,
    job varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    PRIMARY KEY (id)
    ) ENGINE=InnoDB;