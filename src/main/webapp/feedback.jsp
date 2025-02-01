<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <%@ include file="link.jsp" %>
  </head>
  <body >
    <%@ include file="header.jsp" %>

    <div   class="content_container py-4 d-flex  flex-column justify-content-center align-items-center ">
      <h2> Fill the Feedback Form:</h2>

      <form action="<%=application.getContextPath() %>/feedback" method="post" class="mt-3 text white">
      <!--Email field -->
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Email address</label>
          <input  placeholder="Enter here"  name="email"  type="email" class="form-control" id="exampleInputEmail1" >
        </div>
        <!-- phone number -->
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Phone number</label>
          <input type="Phone number" name="phone" placeholder="Enter here" class="form-control" id="exampleInputPassword1">
        </div>

        <!-- feedback -->
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Your Feedback Message</label>
                  <textarea name="feedback_message" rows="10"  placeholder=" Enter here"   class="form-control " >  </textarea>

                </div>

        <div class="container text-center">
        <button type="submit" class="btn btn-warning">Submit</button>
        <button type="reset" class="btn btn-light">Reset</button>
        </div>
      </form>
    </div>

    <%@ include file="scripts.jsp" %>
  </body>
</html>