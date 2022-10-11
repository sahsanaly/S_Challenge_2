CREATE TABLE IF NOT EXISTS account (
    account_number int NOT NULL AUTO_INCREMENT,
    id int NOT NULL,
    account_type varchar(255) NOT NULL,
    account_name varchar(255) NOT NULL,
    balance varchar(255) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (account_number)
) ENGINE=InnoDB;