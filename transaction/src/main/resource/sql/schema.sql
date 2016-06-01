CREATE TABLE account (
  id    INT         NOT NULL AUTO_INCREMENT,
  name  VARCHAR(20) NOT NULL,
  money DOUBLE               DEFAULT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;
INSERT INTO account
VALUES
  (1, 'aaa', 1000),
  (2,'bbb',1000),
  (3,'ccc',1000);