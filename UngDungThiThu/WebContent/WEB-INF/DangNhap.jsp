
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Login</title>

    <!-- Bootstrap core CSS-->
    <link href="NoiDungWeb/DangNhap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="NoiDungWeb/DangNhap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="NoiDungWeb/DangNhap/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        
        <div class="card-body">
       
          <form method="post" action="DangNhap">
           <div class="form-group" id="luachon">
            <div class="checkbox">
                <label>
                  <input type="radio" name="vaitro" value="1" required/>
                 	Thí sinh
                </label>
                <label>
                  <input type="radio" name="vaitro" value="2" required/>
                 Quản lý thí sinh
                </label>
                <label>
                  <input type="radio" name="vaitro" value="3" required/>
                  Quản lý đề thi
                </label>
                <label>
                  <input type="radio" name="vaitro" value="4" required/>
                  Quản lý câu hỏi
                </label>
           </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="inputEmail" class="form-control" name="txtTaiKhoang" placeholder="tài khoảng" required="required" autofocus="autofocus">
                <label for="inputEmail">tài khoảng</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control"name="txtMatKhau"  placeholder="Password" required="required">
                <label for="inputPassword">Password</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Remember Password
                </label>
              </div>
            </div>
            <button class="btn btn-primary btn-block"type="submit">Login</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.html">Register an Account</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="NoiDungWeb/DangNhap/vendor/jquery/jquery.min.js"></script>
    <script src="NoiDungWeb/DangNhap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="NoiDungWeb/DangNhap/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
