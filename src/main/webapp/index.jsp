<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback-Form</title>
    <%@ include file="link.jsp" %>

  </head>
<body style="background-image: url('<%= application.getContextPath() %>/image/e.jpg'); background-size: cover; background-position: center; background-repeat: no-repeat;">

    <%@ include file="header.jsp" %>

    <div  style="height:80vh" class="content_container py-4 d-flex  flex-column justify-content-center align-items-center ">
           <a href="<%=application.getContextPath()%>/feedback.jsp" class="btn btn-dark">Give me Feedback</a>

    </div>

<br>
    <!-- Read Feedback Button -->
    <form action="feedback" method="get" style="height:10vh" class="contents py-4 d-flex  flex-column justify-content-center align-items-center " ">
        <button style="  border-radius:10px" type="submit">Read Past Feedback</button>
    </form>

    <%@ include file="scripts.jsp" %>
  </body>
</html>