<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.09.2016
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/registrationCSS.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/basis.css"/>">
</head>
<body>
<jsp:include page="base.jsp"/>
<div class="window">
    <div class="container">
        <div class="main">
            <div class="registration">
                <h1>New User? <span> Create a account </span></h1>
                <div class="registration_form">
                    <form id="registr" action="" method="post">
                        <div>
                            <label>
                                <input placeholder="Enter your fullname:" type='text' class="inputform" id="name"
                                       name='fullname' required autofocus value=${name}>${errorMessageName}
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="Enter e-mail:" type='email' class="inputform" id="login"
                                       name='login'
                                       required value=${login}>${errorMessageLogin}
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="Enter password at least 6 character:" type='password'
                                       class="inputform"
                                       required id="password" name='password'> ${errorMessagePassword}
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="Confirm password:" type='password' class="inputform" required
                                       id="repassword" name='repassword'> ${errorMessagePassword}
                            </label>
                        </div>
                        <div class="sky-form">
                            <ul>
                                <li><label class="radio left"><input type="radio" name="gender" value="1"
                                                                     checked>Male ${errorMessageGender}</label>
                                </li>
                                <li><label class="radio"><input type="radio" name="gender"
                                                                value="0"><i></i>Female</label>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <label>
                                <select class="inputform" name='country' required>
                                    <option></option>
                                    <option disabled> Select city</option>
                                    <option value="London">London</option>
                                    <option value="Kazan">Kazan</option>
                                    <option value="Berlin">Berlin</option>
                                    <option value="Moscow">Moscow</option>
                                    <option value="Brazil">Brazil</option>
                                </select>
                            </label>
                        </div>
                        <div>
                            <label>
                            <textarea class="inputform" name='aboutYourself'
                                      placeholder='Read about yourself'>${about}</textarea>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input class="inputform" type="text" placeholder="Enter your love singer:"
                                       name="loveSinger"> ${singer}
                            </label>
                        </div>
                        <div>
                            <label class="checkbox"><input type="checkbox" name="newsletter">Subcsribe
                                newsletter</label>
                        </div>
                        <div>
                            <input id="register-submit" type="submit" onclick="validate()" value="create an account">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clear-float"></div>
<div class="banner-bottom"></div>
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/jquery-validation/1.15.1/jquery.validate.js"></script>
<script src="<c:url value="/js/checkDataRegistration.js"/>"></script>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--<meta charset="UTF-8">--%>
<%--<title>Registration</title>--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="../../css/registrationCSS.css"/>">--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="../../css/basis.css"/>">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="main">--%>
<%--<c:if test="${not empty message}">--%>
<%--<h3>${message}</h3>--%>
<%--</c:if>--%>
<%--<form class="validate" id="registr" action='' method='POST'>--%>
<%--<p> Enter your fullname <br>--%>
<%--<input type='text' class="inputform" id="name" name='fullname' value=${name}>${errorMessageName} </p>--%>
<%--<p>Enter e-mail <br>--%>
<%--<input type='email' class="inputform" id="login" name='login' value=${login}>${errorMessageLogin} </p>--%>
<%--<p> Enter password at least 6 character <br>--%>
<%--<input type='password' class="inputform" id="password" name='password'> ${errorMessagePassword}</p>--%>
<%--<p> Confirm password<br>--%>
<%--<input type='password' class="inputform" id="repassword" name='repassword'></p>--%>
<%--<input type='radio' name='gender' value='1' checked> Male ${errorMessageGender}<br>--%>
<%--<input type='radio' name='gender' value='0'> Female <br>--%>
<%--<p><select name='country' required>--%>
<%--<option></option>--%>
<%--<option disabled> Select city</option>--%>
<%--<option value="London">London</option>--%>
<%--<option value="Kazan">Kazan</option>--%>
<%--<option value="Berlin">Berlin</option>--%>
<%--<option value="Moscow">Moscow</option>--%>
<%--<option value="Brazil">Brazil</option>--%>
<%--</select></p>--%>
<%--<p><textarea name='aboutYourself' placeholder='Read about yourself'>${about}</textarea></p>--%>
<%--<p> Enter your love singer<br>--%>
<%--<input type="text" name="loveSinger"> ${singer}</p>--%>
<%--<p><input type='checkbox' name='newsletter'> Subcsribe newsletter </p>--%>
<%--<input type='submit' onclick="validate()" value='Registration'></form>--%>
<%--</div>--%>
<%--<script src="webjars/jquery/1.9.1/jquery.js"></script>--%>
<%--<script src="webjars/jquery-validation/1.15.1/jquery.validate.js"></script>--%>
<%--<script src="<c:url value="../../js/checkDataRegistration.js"/>"></script>--%>

<%--</body>--%>
<%--</html>--%>


