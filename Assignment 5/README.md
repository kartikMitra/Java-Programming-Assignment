# FeedbackApp – Java Servlet Web Application

This project implements the **CSIT751 Core Java, Module V** practical assignment.

## Features

- HTML feedback form with Name, Email, Feedback Type and Comments.
- Sends form data to a Java Servlet using HTTP `POST`.
- Servlet reads submitted values with `request.getParameter()`.
- Displays the thank-you message, feedback type, comments, and current date/time.
- Servlet is mapped to `/submitFeedback` in `web.xml`.

## Technologies

- Java 8 or later
- HTML and CSS
- Java Servlet API 4.0 (`javax.servlet`)
- Apache Tomcat 9
- Maven

> Compatibility: This project uses `javax.servlet`, so use **Tomcat 9**. Tomcat 10+ uses `jakarta.servlet` and requires code/package changes.

## Project structure

```text
FeedbackApp/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── feedbackapp/
        │           └── FeedbackServlet.java
        └── webapp/
            ├── feedback.html
            └── WEB-INF/
                └── web.xml
```

## Run using Maven and Tomcat 9

1. Install JDK 8+ and Maven.
2. Install Apache Tomcat 9.
3. Open a terminal in the project folder.
4. Build the WAR file:

   ```bash
   mvn clean package
   ```

5. Copy `target/FeedbackApp.war` into Tomcat's `webapps` folder.
6. Start Tomcat.
7. Open:

   ```text
   http://localhost:8080/FeedbackApp/
   ```

8. Fill in the form and click **Submit Feedback**.

## Run from an IDE

Import the folder as an existing Maven project in Eclipse or IntelliJ IDEA. Configure a Tomcat 9 server, add the project as a deployment, and start the server.

## Upload to GitHub

Create an empty repository on GitHub. Then run these commands from this project folder:

```bash
git init
git add .
git commit -m "Add FeedbackApp Java Servlet project"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/FeedbackApp.git
git push -u origin main
```

Replace `YOUR-USERNAME` with your GitHub username.

## Assignment requirement checklist

- [x] `feedback.html` contains Name, Email, Feedback Type dropdown and Comments textarea.
- [x] Form submits using POST.
- [x] `FeedbackServlet.java` reads fields using `request.getParameter()`.
- [x] Response includes the required thank-you message.
- [x] Response displays feedback type and comments.
- [x] Response displays current date and time.
- [x] `web.xml` maps `FeedbackServlet` to `/submitFeedback`.

## Notes

- Feedback is displayed in the response; this assignment version does not store submissions in a database.
- User-entered values are HTML-escaped before display.
