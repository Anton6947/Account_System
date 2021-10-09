CREATE SCHEMA HR;

CREATE SEQUENCE HR.GENERIC_SEQ
    START WITH 50002
    INCREMENT BY 1;

CREATE TABLE hr.ACCOUNT_TYPE
(
    ACCOUNT_TYPE_ID  BIGINT NOT NULL,
    MNEMONIC    VARCHAR(100) NOT NULL UNIQUE,
    ACCOUNT_TYPE_NAME       VARCHAR(255)  NOT NULL,
    CREATION_DATE       DATE NOT NULL,
    PRIMARY KEY (ACCOUNT_TYPE_ID)
);

CREATE TABLE HR.ACCOUNT_TRANSACTION
(
    TRANSACTION_ID  BIGINT NOT NULL,
    ACCOUNT_TYPE_ID  BIGINT NOT NULL,
    MEMBER_ID  BIGINT NOT NULL,
    AMOUNT  BIGINT    NOT NULL,
    TRANSACTION_DATE   DATE NOT NULL,
    PRIMARY KEY (TRANSACTION_DATE),
    CONSTRAINT  FK_ACCOUNT_TYPE_IDL FOREIGN KEY (ACCOUNT_TYPE_ID) REFERENCES HR.ACCOUNT_TYPE (ACCOUNT_TYPE_ID),
);