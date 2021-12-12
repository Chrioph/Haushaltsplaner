Git Workflow:

1.  New Branch from development
2.  Implement your task
3.  Merge Branch back to development
4.  Test on development
5.  Merge with production


Start DB:

1.  Go to %USER_PROFILE%/<username>/.m2/repository/com/h2database/h2/1.4.200
2.  Execute h2-1.4.200.jar
3.  To login:
        DB:  jdbc:h2:<Path to IntelliJ project>\Haushaltsplaner\src\main\resources\Haushaltsplaner
        user: ch
        password: hpotsirhc


Start Frontend:

New run configuration -> npm -> command: run
or
Go to Terminal in IntelliJ (bottom) -> type "npm run"
Note: Maybe you have to run "npm install" first to install new/initial npm modules

