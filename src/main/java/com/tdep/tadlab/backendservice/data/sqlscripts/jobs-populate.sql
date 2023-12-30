-- Create Jobs

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (1, 'The Berry Farm', '2004-03-01','2013-08-30');

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (2, 'Roli', '2017-07-01','2018-07-30');

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (3, 'CUNY Brooklyn College', '2014-08-01','2019-05-30');

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (4, 'Arolla Piano Co.', '2019-06-01','2020-01-30');

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (5, 'Flatiron School', '2022-10-31','2023-02-15');

INSERT INTO JOB (ID, NAME, START_DATE, END_DATE)
VALUES (6, 'Spotify', '2023-08-26','2024-02-03');

-- Create Roles

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (11, 'Farm Hand','Performed a variety of tasks during building renovations including: demolition, framing, paint removal and application while maintaining safe working practices and environments.

Operated and worked around large machinery to perform a variety of farm tasks such as plowing, tilling, hole drilling, digging, towing, and mowing.

Carried out a multitude of regular farm tasks such as planting, pruning, harvesting, weed control, fertilizing, and irrigation building while making sure to use the latest and most effective processes yielding the best crops', 1);

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (21, 'Creator (Tech) Support Agent','Designed and implemented a system to track and catalog product shipments and returns using Google Sheets and Google Docs significantly reducing the turnover period of returns from 5 weeks to 2 weeks and reducing lost shipments from 4% to 1%.

Coordinated between Tech Support, Sales, Logistics, and Package Carriers in order to provide a smooth transaction for customers by providing accurate updates using the aforementioned cataloging system and reducing interdepartmental lead times from 5 to 2 business days.

Created documentation and project description outlining the returns process and how it should continue to expand in order to provide a guideline for a future RMA system and returns department.

Initiated and performed repairs of MIDI instruments in New York reducing the turnaround for faulty products within the US and Canada from 8 weeks to 2 weeks.', 2);

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (31, 'Graduate Student','Earned a Masters in Music (MM) degree in Composition with a focus on orchestral and experimental playback. Performed original and existing music in small ensembles for live audiences.

Presented research projects on historical subjects and created reports on analytical topics in traditional western music theory as well as Shenkerian analysis.

Designed and built a handful of electronic music instruments using resistor-capacitor circuits, Arduino, and integrated circuits.

As a final thesis, composed a 27 minute, multi-movement symphony for 60-piece orchestra.', 3);

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (41, 'Piano Technician','Provided piano tuning, regulation and repair services to an average of 10 clients a week using electronic and ear techniques with standard piano tuning and repair tools in order to bring their instrument to its designed specs, allowing it to sound its best, and resolve or prevent performance issues in client pianos.

Maintained a database of clients as well as payment and invoicing tooling using Google Sheets, Xero invoicing, and Square payments in order keep track of client service records, payments, and future service needs.', 4);

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (51, 'Student','Studied front and back-end development in JavaScript, React, Ruby on Rails, and Python / Flask. Designed, wireframed, and developed several applications both individually and as part of a team using combinations of the aforementioned languages and existing or custom APIs.

Assisted other students with their studies and projects helping to ensure the class as a whole was able to achieve the most out of the time on and off campus. This included leading study and review sessions outside of normal class hours.

Independently learned additional tools such as React Redux and more advanced CSS concepts. Demonstrated and presented applications in front of audiences of students and teachers giving user scenarios and explanations of code as well as experiences thereof.', 5);

INSERT INTO ROLE (ID, TITLE, DESCRIPTION, JOB)
VALUES (61, 'Associate Engineering Fellow','Designed and built a Java backend service and server-side client to provide a frontend application with user specific query results from a database using gRPC requests to interface with an external service to create a custom, curated playlist.

Wrote validations, unit, and integration tests to prevent erroneous database queries and empty responses removing unhandled bad requests and database errors ensuring exceptions are handled appropriately and multiple failing cases are accounted for.

Defined new gRPC services using Protobuf serializers and including pagination designed to replace existing RESTful services providing multiple endpoints covering read and write functionality.

Wrote new service handlers for incoming gRPC requests that implement existing RESTful endpoints for read and write functionality.', 5);