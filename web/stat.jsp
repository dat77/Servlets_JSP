<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Questionnaire</title>
  </head>
  <body>
    <% int count = (int)session.getAttribute("user_count"); %>

    <% if (count >=1) { %>
            <h1> <%= (String)session.getAttribute("xml_statistic") %> </h1> <br>
            Last user : <%=  (String)session.getAttribute("user_firstName") + " " + (String)session.getAttribute("user_lastName") + " #" + count %> <br>
            Age: <%= (String)session.getAttribute("stat_age") %> <br>
            Sport: <%= (String)session.getAttribute("stat_sport") %> <br>
            Books: <%= (String)session.getAttribute("stat_books") %> <br>

            <br>Click this link to <a href="/index.html">pass throw the questionnaire</a>
    <% } else { %>
        <br>Click this link to <a href="/index.html">pass throw the questionnaire</a>
    <% } %>
  </body>
</html>
