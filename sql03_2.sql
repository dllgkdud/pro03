commit;

-- notice테이블
CREATE TABLE notice(
	no INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100),
	content VARCHAR(500),
	regDate DATE DEFAULT NOW(),
	visited INT DEFAULT 0
);

-- 더미데이터
INSERT INTO notice(title, content) VALUES(
	"공지사항1",
	"공지사항1의 내용입니다."
);
SELECT * FROM notice;
update notice set visited=visited+1 WHERE NO=1;


-- user테이블
CREATE TABLE user(
	id VARCHAR(30) PRIMARY KEY,
	pw VARCHAR(300) NOT NULL,
	name VARCHAR(30) NOT NULL,
	tel VARCHAR(11) NOT NULL,
	birth DATE,
	email VARCHAR(50) NOT NULL,
	addr VARCHAR(500) NOT NULL,
	grade VARCHAR(5) DEFAULT "F",
	visited INT DEFAULT 1,
	regdate DATETIME DEFAULT NOW()
);
SELECT * from user;
ALTER TABLE user modify pw VARCHAR(300);
ALTER TABLE user modify grade VARCHAR(5) DEFAULT "F";
ALTER TABLE user add regdate DATETIME DEFAULT NOW();
UPDATE user SET grade="M" WHERE id="admin";