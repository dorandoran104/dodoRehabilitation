--병원 리스트 테이블
DELETE hospitallist;

CREATE TABLE hospitallist (
    hpid       VARCHAR2(9) PRIMARY KEY,
    dutyname   VARCHAR2(100),
    dutydivnam CHAR(1) NOT NULL,
    dutyaddr   VARCHAR2(200),
    dutytel1   VARCHAR2(15),
    dutytime1s VARCHAR2(10),
    dutytime2s VARCHAR2(10),
    dutytime3s VARCHAR2(10),
    dutytime4s VARCHAR2(10),
    dutytime5s VARCHAR2(10),
    dutytime6s VARCHAR2(10),
    dutytime7s VARCHAR2(10),
    dutytime8s VARCHAR2(10),
    wgs84lat   VARCHAR2(25),
    wgs84lon   VARCHAR2(25)
);

SELECT
    *
FROM
    hospitallist;

UPDATE hospitallist
SET
    dutytime1s = '휴진'
WHERE
    dutytime1s = 'null~null';

COMMIT;
--댓글 테이블+시퀀스
DROP TABLE commentboard;

DROP SEQUENCE comm_id_seq;

CREATE TABLE commentboard (
    id         NUMBER(10)
        CONSTRAINT comm_id_pk PRIMARY KEY,
    hpid       VARCHAR2(9) NOT NULL,
    body       VARCHAR2(400) NOT NULL,
    writedate  DATE DEFAULT sysdate,
    updatedate DATE DEFAULT sysdate,
    nickname   VARCHAR(10) NOT NULL,
    userid     NUMBER(10) NOT NULL
);

CREATE SEQUENCE comm_id_seq START WITH 1;

--회원 테이블, 시퀀스
DROP TABLE member;

DROP SEQUENCE mem_id_seq;

CREATE TABLE member (
    id        NUMBER(10)
        CONSTRAINT mem_id_pk PRIMARY KEY,
    nickname  VARCHAR2(10) NOT NULL,
    userid    VARCHAR2(10) UNIQUE NOT NULL,
    userpwd   VARCHAR2(60) NOT NULL,
    phone     VARCHAR2(20),
    email     VARCHAR2(60),
    regdate   DATE DEFAULT sysdate,
    delmember CHAR(1) DEFAULT 0,
    deldate   DATE
);

INSERT INTO member (
    id,
    nickname,
    userid,
    userpwd
) VALUES (
    - 1,
    'admin',
    'admin',
    'admin'
);

COMMIT;

COMMIT;

CREATE SEQUENCE mem_id_seq START WITH 1;

DROP TABLE bboard;

CREATE TABLE bboard (
    id         NUMBER(10)
        CONSTRAINT bb_id_pk PRIMARY KEY,
    title      VARCHAR2(400) NOT NULL,
    body       VARCHAR2(450) NOT NULL,
    nickname   VARCHAR2(10) NOT NULL,
    usernum    NUMBER(10) NOT NULL,
    secret     CHAR(2) DEFAULT 0,
    regdate    DATE DEFAULT sysdate,
    updatedate DATE DEFAULT sysdate
);

DROP SEQUENCE bb_id_seq;

CREATE SEQUENCE bb_id_seq START WITH 1;


--정보수정 db테이블
DROP TABLE adminboard;

DROP SEQUENCE mi_bo_seq;

CREATE TABLE adminboard (
    id      NUMBER(10)
        CONSTRAINT ad_bo_pk PRIMARY KEY,
    body    VARCHAR2(400) NOT NULL,
    type    VARCHAR2(30) NOT NULL,
    writer  VARCHAR2(10) NOT NULL,
    hpid    VARCHAR2(9) NOT NULL,
    regdate DATE DEFAULT sysdate
);

CREATE SEQUENCE ad_bo_seq;

SELECT
    a.*,
    h.dutyname AS dutyname
FROM
    adminboard   a
    LEFT JOIN hospitallist h ON ( a.hpid = h.hpid )
ORDER BY
    id DESC;

ROLLBACK;