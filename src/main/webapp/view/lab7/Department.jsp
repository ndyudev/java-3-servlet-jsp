<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Department Management</title>
<style>
  * {
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
  }

  body {
    background: #f7f8fa;
    color: #333;
    padding: 20px;
  }

  h3 {
    color: #007bff;
    margin-bottom: 10px;
  }

  form {
    background: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    margin-bottom: 20px;
    width: 400px;
  }

  label {
    font-weight: bold;
    display: block;
    margin-top: 10px;
  }

  input[type="text"], textarea {
    width: 100%;
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    margin-top: 5px;
    font-size: 14px;
    transition: border 0.2s;
  }

  input[type="text"]:focus, textarea:focus {
    border-color: #007bff;
    outline: none;
  }

  textarea {
    resize: vertical;
  }

  hr {
    border: none;
    border-top: 1px solid #eee;
    margin: 15px 0;
  }

  button {
    background: #007bff;
    color: #fff;
    border: none;
    padding: 8px 15px;
    border-radius: 6px;
    cursor: pointer;
    margin-right: 8px;
    transition: 0.2s;
  }

  button:hover {
    background: #0056b3;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    background: #fff;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    border-radius: 8px;
    overflow: hidden;
  }

  th, td {
    padding: 10px 12px;
    text-align: left;
  }

  thead {
    background: #007bff;
    color: #fff;
  }

  tbody tr:nth-child(even) {
    background: #f1f4f8;
  }

  tbody tr:hover {
    background: #e8f0fe;
  }

  a {
    text-decoration: none;
    color: #007bff;
    font-weight: bold;
  }

  a:hover {
    color: #0056b3;
  }

  .message {
    margin-top: 10px;
    color: red;
    font-weight: bold;
  }
</style>
</head>
<body>

  <h3>🏢 Department Form</h3>

  <c:url var="path" value="/department" />
  <form method="post">
    <label>Id:</label>
    <input name="id" value="${item.id}" type="text">

    <label>Name:</label>
    <input name="name" value="${item.name}" type="text">

    <label>Description:</label>
    <textarea name="description" rows="3">${item.description}</textarea>

    <hr>

    <button formaction="${path}/create">Create</button>
    <button formaction="${path}/update">Update</button>
    <button formaction="${path}/delete">Delete</button>
    <button formaction="${path}/reset">Reset</button>
  </form>

  <h3>📋 Department List</h3>
  <table>
    <thead>
      <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="d" items="${list}" varStatus="vs">
        <tr>
          <td>${vs.count}</td>
          <td>${d.id}</td>
          <td>${d.name}</td>
          <td>${d.description}</td>
          <td><a href="${path}/edit/${d.id}">Edit</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="message">${message}</div>

</body>
</html>
