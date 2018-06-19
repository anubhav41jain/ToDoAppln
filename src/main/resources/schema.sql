create table todo(
    id bigint not null auto_increment,
    title varchar(255) not null,
    completed varchar(100),
    createdtime timestamp,
    primary key(id)
);
create table question(
    id bigint not null auto_increment,
    className  varchar(255) not null,
    subject  varchar(255) not null,
    chapter  varchar(255) not null,
    marks int not null,
    ques varchar(255) not null,
    ans  varchar(255) not null,
    primary key(id)
);
create table subjects(
    sub_id bigint not null auto_increment,
    subjectName  varchar(255) not null,
    class_id bigint not null,
    primary key(sub_id)
);
create table classes(
    class_id bigint not null auto_increment,
    className  varchar(255) not null,
    primary key(class_id)
);
create table chapters(
    chap_id bigint not null auto_increment,
    subjectName  varchar(255) not null,
    class_id bigint not null,
    chapterName  varchar(255) not null,
    primary key(chap_id)
);