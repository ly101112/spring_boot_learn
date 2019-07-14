create table question
(
	id int auto_increment,
	title varchar(50) not null,
	description text,
	create_time bigint,
	modified_time bigint,
	uid int not null,
	comment_count int default 0 not null,
	view_count int default 0 not null,
	like_count int default 0 not null,
	tag varchar(256) not null,
	constraint question_pk
		primary key (id)
);

create unique index question_comment_count_uindex
	on question (comment_count);

create unique index question_create_time_uindex
	on question (create_time);

create unique index question_like_count_uindex
	on question (like_count);

create unique index question_modified_time_uindex
	on question (modified_time);

create unique index question_uid_uindex
	on question (uid);

create unique index question_view_count_uindex
	on question (view_count);

