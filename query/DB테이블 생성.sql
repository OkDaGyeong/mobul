CREATE TABLE user(
  user_id INT(11) NOT NULL primary key,
  user_password VARCHAR(20) NOT NULL,                     
  user_phone VARCHAR(20) NULL,                     
  -- CONSTRAINT testTable_PK PRIMARY KEY(id)    -- 제약 조건의 이름을 붙여줌       
);
