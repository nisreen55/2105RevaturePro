
--/***********************Project 1 Schema ***************************//

CREATE TABLE ers_reimbursement(
reimb_id INTEGER PRIMARY KEY ,
reimb_amount FLOAT NOT NULL,
reimb_submitted TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, 
reimb_resolved TIMESTAMP,
reimb_description VARCHAR(250),
reimb_reciept BYTEA,
reimb_author INTEGER,
reimb_resolver INTEGER,
reimb_status_id INTEGER DEFAULT 1,
reimb_type_id INTEGER,
CONSTRAINT	ers_users_fk_auth FOREIGN KEY(reimb_author)
			REFERENCES ers_users(ers_users_id)
			ON DELETE CASCADE ON UPDATE cascade,
CONSTRAINT	ers_users_fk_reslvr FOREIGN KEY(reimb_resolver)
			REFERENCES ers_users(ers_users_id)
            ON DELETE CASCADE ON UPDATE cascade,
CONSTRAINT	ers_reimursement_status_fk FOREIGN KEY(reimb_status_id)
			REFERENCES ers_reimbursement_status(reimb_status_id)
            ON DELETE CASCADE ON UPDATE cascade,
CONSTRAINT	ers_reimursement_type_fk FOREIGN KEY(reimb_type_id)
			REFERENCES ers_reimbursement_type(reimb_type_id)
            ON DELETE CASCADE ON UPDATE cascade
);


CREATE TABLE ers_users(
ers_users_id INTEGER,
ers_username VARCHAR(50) NOT NULL,
ers_password VARCHAR(50) NOT NULL,
user_first_name VARCHAR(100)NOT NULL,
user_last_name VARCHAR(100)NOT NULL,
user_email VARCHAR(150) UNIQUE NOT NULL ,
user_role_id INTEGER NOT NULL,
CONSTRAINT ers_users_pk PRIMARY KEY(ers_users_id),
CONSTRAINT users_roles_fk FOREIGN KEY(user_role_id) 
		   REFERENCES ers_user_roles(ers_user_role_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ers_reimbursement_status(
reimb_status_id INTEGER NOT NULL,
reimb_status VARCHAR(20) NOT NULL,
CONSTRAINT reimb_status_pk PRIMARY KEY (reimb_status_id)
);


CREATE TABLE ers_reimbursement_type(
reimb_type_id INTEGER NOT NULL,
reimb_type VARCHAR(20) NOT NULL,
CONSTRAINT reimb_type_pk PRIMARY KEY (reimb_type_id)
);


CREATE TABLE ers_user_roles(
ers_user_role_id INTEGER NOT NULL,
user_role VARCHAR(20) NOT NULL,
CONSTRAINT ers_user_roles_pk PRIMARY KEY (ers_user_role_id)
);


CREATE TABLE ticketView(
reimb_id INTEGER  ,
reimb_amount FLOAT NOT NULL,
reimb_submitted TIMESTAMP , 
reimb_resolved TIMESTAMP,
reimb_description VARCHAR(250),
reimb_reciept BYTEA,
reimb_author VARCHAR(50),
reimb_resolver VARCHAR(20),
reimb_status VARCHAR(20),
reimb_type VARCHAR(20),
reimb_user_name VARCHAR(20)
);

CREATE TABLE ReimID(
reimbId varchar(30)
);
SELECT * FROM ers_user_roles ; 















