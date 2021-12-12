# Haushaltsplaner
Web Application for managing household tasks and budget

Initialize Project:
- Get NodeJs, Git, Java (for running the DB jar file) and (preferably) IntelliJ
- Clone the repository from Github
- In the IntellJ Terminal (bottom) go to the frontend folder and execute "npm install"
- Go to the pom.xml and press Strg + Shift + O to resolve the project dependencies


Git Workflow:

1.  New branch from development with name #<task_number>: <short_description>
2.  Implement your task
3.  Merge branch back to development
4.  Delete branch
5.  Test on development
6.  Merge with production
    Note: main branch shall not be used


Start DB:

1.  Go to %USER_PROFILE%/<username>/.m2/repository/com/h2database/h2/1.4.200
2.  Execute h2-1.4.200.jar
3.  To log into web interface:
    DB:  jdbc:h2:<Path to IntelliJ project>\Haushaltsplaner\src\main\resources\Haushaltsplaner
    user: ch
    password: hpotsirhc


Start Frontend:

New run configuration -> npm -> command: run
or
Go to Terminal in IntelliJ (bottom) -> change folder to frontend -> type "npm run"
Note: Maybe you have to run "npm install" first to install new/initial npm modules


Start Backend:

1. Start the DB
2. Run the configuration "HousekeepingPlannerApplication" which should automatically be created by IntelliJ

