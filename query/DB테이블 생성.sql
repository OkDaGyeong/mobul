drop table users;
drop table boards;
drop table boards_file;

CREATE TABLE users(                              
  user_id varchar(11) NOT NULL primary key,
  user_password VARCHAR(20) NOT NULL,                     
  user_phone VARCHAR(20) NULL,
  user_one varchar(20),
  user_two varchar(20),
  user_three varchar(20)
);

CREATE TABLE boards(                              
  board_id INT(11) primary key AUTO_INCREMENT,
  board_title VARCHAR(50) NOT NULL,                     
  board_content VARCHAR(255) not NULL,
  board_view int(10) not null,
  board_writer varchar(11) not null,
  board_like int(5) not null,
  board_tag varchar(20) null,
  borad_date date null,
  board_one varchar(20) null,
  board_two varchar(20) null,
  board_three int(10) null,
  board_four int(10) null
);

-- 유저스  테이블 있는  pk(user_id)를 borads 테이블의 외래키(board_writer <<- 얘를 외래키로 )로 사용한다 
alter TABLE boards 
add constraint board_user
FOREIGN KEY(board_writer) references users(user_id) 
on delete cascade 
on update cascade;
-- board_writer을 user_id의 외래키로 설정 , 별칭은 board_user 로 설정


-- boards_file table 생성 
-- file_board_num 을 board_num의 외래키로 설정   별칭을 fk_file_board_num으로 설정
CREATE TABLE boards_file(
    file_id INT(11) PRIMARY KEY not null AUTO_INCREMENT,
    file_board_num INT(11) not null,    -- boards 테이블 board_id와 연결
    file_img BLOb null,
    file_one int(10),
    file_two varchar(10),
    file_three varchar(15),
    
    CONSTRAINT fk_file_board_id
        FOREIGN KEY (file_board_num) REFERENCES boards(board_id)
        ON DELETE CASCADE
        on update cascade
);


-- comments table 생성
Create table comments(
	comment_id int(11) primary key AUTO_INCREMENT,
    comment_content VARCHAR(150) not null,
    comment_writer varchar(11) 	not null,
    comment_date DATE not null,         -- now
    comment_board_num int(11) not null, -- fk 설정 boards 테이블 board_id와 연결
    comment_one varchar(10),
	comment_two int(10),
    comment_three varchar(20),
	CONSTRAINT fk_comment_board_num
        FOREIGN KEY (comment_board_num) REFERENCES boards(board_id)
        ON DELETE CASCADE
        on update cascade
    
);

create table replies(
	reply_id int(11) PRIMARY key auto_increment,
    reply_content varchar(150) not null,
    reply_writer varchar(11) not null,
    reply_date date not null,
    reply_comment_num int(11) not null,  -- fk 설정
	CONSTRAINT fk_reply_comment_num
        FOREIGN KEY (reply_comment_num) REFERENCES comments(comment_id)
        ON DELETE CASCADE
        on update cascade
);    
    