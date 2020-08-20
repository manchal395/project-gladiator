COMMIT;

CREATE TABLE FLIGHTS (
    id NUMBER(4) PRIMARY KEY,
    airlines VARCHAR2(20) NOT NULL,
    max_seats NUMBER(3),
    max_baggage_kg NUMBER(2)
);

INSERT INTO FLIGHTS VALUES(001, 'Air India', 50, 21);
INSERT INTO FLIGHTS VALUES(002, 'Indigo', 40, 20);
INSERT INTO FLIGHTS VALUES(003, 'Air India', 50, 21);
INSERT INTO FLIGHTS VALUES(004, 'Vistara', 50, 15);


CREATE TABLE ROUTES(
    id NUMBER(4) PRIMARY KEY,
    source VARCHAR2(20) NOT NULL,
    destination VARCHAR2(20) NOT NULL
);

INSERT INTO ROUTES VALUES(101, 'Delhi', 'Mumbai');
INSERT INTO ROUTES VALUES(102, 'Mumbai', 'Delhi');
INSERT INTO ROUTES VALUES(103, 'Delhi', 'Pune');
INSERT INTO ROUTES VALUES(104, 'Pune', 'Delhi');
INSERT INTO ROUTES VALUES(105, 'Bangalore', 'Chennai');
INSERT INTO ROUTES VALUES(106, 'Chennai', 'Bangalore');


CREATE TABLE SCHEDULE(
    id NUMBER(4) PRIMARY KEY,
    route_id NUMBER(4),
    depart TIMESTAMP NOT NULL,
    arrive TIMESTAMP NOT NULL,
    CONSTRAINT route_fk FOREIGN KEY (route_id) REFERENCES ROUTES(id)
);

-- alter FLIGHT_SCHEDULE table later for booking module; add available_seats property

CREATE TABLE FLIGHT_SCHEDULE(
    id NUMBER(4) PRIMARY KEY,
    schedule_id NUMBER(4),
    flight_id NUMBER(4),
    economy DOUBLE PRECISION NOT NULL,
    business DOUBLE PRECISION
);

