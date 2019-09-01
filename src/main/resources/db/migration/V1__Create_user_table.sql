CREATE TABLE www.user
(
    id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    account_id varchar(100) NOT NULL,
    name varchar(50) NOT NULL,
    token varchar(36) NOT NULL,
    create_time bigint,
    modified_time bigint
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;