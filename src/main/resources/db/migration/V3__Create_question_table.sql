CREATE TABLE question
(
	id int AUTO_INCREMENT PRIMARY KEY,
	title varchar(50) NOT NULL,
	description text NOT NULL,
	create_time bigint NOT NULL,
	modified_time bigint NOT NULL,
	uid int NOT NULL,
	comment_count int DEFAULT 0 NOT NULL,
	view_count int DEFAULT 0 NOT NULL,
	like_count int DEFAULT 0 NOT NULL,
	tag varchar(256) DEFAULT '' NOT NULL
)ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;