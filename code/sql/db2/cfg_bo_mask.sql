-- CREATE TABLE
CREATE TABLE CFG_BO_MASK(
BO_NAME 							VARCHAR(255) NOT NULL,
ATTR_NAME							VARCHAR(255) NOT NULL,
MASK_FUNCTION_CLASS		VARCHAR(255) NOT NULL,
STATE									CHARACTER(1)	NOT NULL,
REMARKS								VARCHAR(255),
CONSTRAINT PK_CFG_BO_MASK PRIMARY KEY (BO_NAME,ATTR_NAME)
)