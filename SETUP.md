# How to set up and run:

1) Update database credentials in hibernate.cgf.xml to point
to your local database
2) Build the Maven project
3) Run the app!

Note: you will need to remove <property name="hbm2ddl.auto">create</property> line from 
session properties in hibernate.cgf.xml if you want to keep your data between sessions.
We need this line to automatically create all the tables needed for the app to run.