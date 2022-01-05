# Hibernate Activity Planning App

## Requirements:

1) Project was upated to use JDK 11.
2) Maven 3.8.4 was used for the latest build.

## Setup:

1) Update database credentials in hibernate.cgf.xml to point to your local Postgres database.
2) Run the SQL queries in `public/sql/init.sql` to initialize the tables used by the application.
3) Navigate to the project folder and run `mvn package` in your terminal.
4) Run the project using the following command: `mvn exec:java -Dexec.mainClass=Main`.
