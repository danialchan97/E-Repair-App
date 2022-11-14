<%-- 
    Document   : table
    Created on : Dec 18, 2018, 11:47:09 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../../stylesheets/coloringpage.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="../../stylesheets/coloringpageprint.css" type="text/css" media="print" />
<style>

html,
body {
  height: 100%;

}

body {
  margin: 0;
  background: linear-gradient(45deg, #49a09d, #5f2c82);
  font-family: sans-serif;
  font-weight: 100;
  background-attachment: fixed;
  overflow-x: hidden;
}

.container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

caption{
  background: rgba(0, 0, 0, 0.7);
  padding: 20px;
  font-size: 1.4em;
  font-weight: normal;
  text-align: center;
  text-transform: uppercase;
  color: #fff;
}

table {
  width: 50%;
  border-spacing: 2;
  border: 10;
  border-collapse: collapse;
  overflow: scroll;
  box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
  padding: 15px;
  background-color: rgba(255,255,255,0.8);
  color: #fff;
}

p{
  color:black;
}
th {
  text-align: left;
  width: 30%;
    background: rgba(0, 0, 0, 0.5);
}

thead {
  th {
    background-color: #55608f;
  }
}

tbody {
  tr {
    &:hover {
      background-color: rgba(255,255,255,0.3);
    }
  }
  td {
    position: relative;
    &:hover {
      &:before {
        content: "";
        position: absolute;
        left: 0;
        right: 0;
        top: -9999px;
        bottom: -9999px;
        background-color: rgba(255,255,255,0.2);
        z-index: -1;
        overflow: scroll;
      }
    }
  }
}
</style>
</html>
