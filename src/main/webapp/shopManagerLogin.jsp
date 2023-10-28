<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/dashboard.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Section: Design Block -->
<section class=" text-center text-lg-start ">
  <style>
    .rounded-t-5 {
      border-top-left-radius: 0.5rem;
      border-top-right-radius: 0.5rem;
    }

    @media (min-width: 992px) {
      .rounded-tr-lg-0 {
        border-top-right-radius: 0;
      }

      .rounded-bl-lg-5 {
        border-bottom-left-radius: 0.5rem;
      }
    }
  </style>
  <div class="card mb-3">
    <div class="row g-0 d-flex align-items-center">
      <div class="col-lg-4 d-none d-lg-flex">
        <img src="./images/logo.jpg" alt="Trendy Pants and Shoes"
          class="w-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
      </div>
      <div class="col-lg-8">
        <div class="card-body py-5 px-md-5">
        
        <c:if test="${not empty requestScope.errorMessage}">
                <div class="alert alert-danger" role="alert">
				  ${requestScope.errorMessage}
				</div>
		</c:if>

          <form method="post" action="ShopManagerLoginServlet">
           
            <div class="form-outline mb-4">
              <input type="text" name="username" id="form2Example1" class="form-control" />
              <label class="form-label" for="form2Example1">Username</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" name="password" id="form2Example2" class="form-control" />
              <label class="form-label" for="form2Example2">Password</label>
            </div>

            <input type="submit" value="Sign in" class="btn btn-primary btn-block mb-4">

          </form>

        </div>
      </div>
    </div>
  </div>
</section>
<!-- Section: Design Block -->
</body>
</html>