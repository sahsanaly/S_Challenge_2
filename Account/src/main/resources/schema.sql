CREATE TABLE IF NOT EXISTS account (
    id int NOT NULL AUTO_INCREMENT,
    account_type varchar(255) NOT NULL,
    account_number varchar(255) NOT NULL,
    account_name varchar(255) NOT NULL,
    balance varchar(255) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;