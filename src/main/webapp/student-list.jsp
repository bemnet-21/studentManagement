<%@ page import="java.util.List, com.learn.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<title>All Students</title>
<style>
    table, th, td { border: 1px solid black; border-collapse: collapse; padding: 10px; }
</style>
</head>
<body>
    <h2>List of Students</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Year</th>
        </tr>
        <% 
            
            List<Student> list = (List<Student>) request.getAttribute("listStudents");
            if (list != null) {
                for (Student s : list) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getYear() %></td>
        </tr>
        <% 
                }
            }
        %>
    </table>
    <br/>
    <a href="index.jsp">Back to Registration</a>
</body>
</html>