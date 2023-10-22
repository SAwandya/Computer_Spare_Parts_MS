<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./css/dashboard.css"/>


<meta charset="UTF-8">
<title>Shop manager dashboard</title>
</head>
<body>

<!-- ---------------------------- Navigation Bar ------------------------------------ -->



	<nav class="mt-0 navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Shop Dashboard</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="http://localhost:8090/Computer_Spareparts__MS/Landing">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"></a>
        </li>
        
        
        
      </ul>
      
     
      
      <form class="d-flex" role="search" method="get" action="Landing">
        <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
        <input class="btn btn-outline-primary" value="Search" type="submit">
      </form>
      
         <c:if test="${not empty sessionScope.mgr}">
		  <form method="post" action="ShopManagerLogoutServlet">
		  	<input type="hidden" name="log" value="logout"/>
		 	<input type="submit" value="Log out" class="btn btn-outline-primary ms-2">
		 	
		</form>
	</c:if>
    </div>
  </div>
</nav>


<!----------------------------Mnager Dshboard -------------------------------------->
	
<section>
	<div class="container mt-5">
    <div class="row">
        <div class="col-12 mb-3 mb-lg-5">
            <div class="overflow-hidden card table-nowrap table-card">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Computer spare parts</h5>
                    <a href="http://localhost:8090/Computer_Spareparts__MS/Landing" class="btn btn-light btn-sm">View All</a>
                </div>
                <div class="table-responsive">
                    <table class="table mb-0">
                        <thead class="small text-uppercase bg-body text-muted">
                            <tr>
                                <th>Type</th>
                                <th>Item Id</th>
                                <th>Brand</th>
                                <th>Unit price</th>
                                <th>Amount</th>
                                <th class="text-center ">PURCHASE</th>
                                <th class="text-center ">Undo Perchase</th>
                                <th class="text-center ">SELL</th>
                                <th class="text-center ">Undo Sell</th>
                                <th class="text-center ">Update</th>                             
                                <th class="text-center">Remove</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach var="item" items="${ItemDetails}">
                            <tr class="align-middle">
                                <td>
                                    <div class="d-flex align-items-center">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="avatar sm rounded-pill me-3 flex-shrink-0" alt="Customer">
                                        <div>
                                            <div class="h6 mb-0 lh-1">${item.type}</div>
                                        </div>
                                    </div>
                                </td>
                                <td>${item.itemId}</td>
                                <td> <span class="d-inline-block align-middle">${item.brandName}</span></td>
                                <td><span>${item.unitPrice}LKR</span></td>
                                <td>${item.amount}</td>
                                
                                <td>
	                                <form method="post" action="IncrementServlet">
	                                	<input type="hidden" value="${item.itemId}" type="text" name="increment">
	                                	<input type="submit" value="PURCHES" class="btn btn-warning align-middle ms-3">
	                                </form>
	                                
	                             
                                </td>
                                
                                <td>
                                	<form method="post" action="UndoItemServlet">
	                                	<input type="hidden" value="${item.itemId}" type="text" name="undo">
	                                	<input type="submit" value="Undo" class="btn btn-outline-secondary">
	                                </form>
                                </td>
                                
                                <td>
                                	<form  method="post" action="DecrementServlet">
	                                	<input type="hidden" value="${item.itemId}" type="text" name="decrement">
                                		<input type="submit" value="SELL" class="btn btn-warning ms-3">
                                	</form>
                                </td>
                                
                                <td>
                                	<form method="post" action="UndoSoldItemServlet">
	                                	<input type="hidden" value="${item.itemId}" type="text" name="undo">
	                                	<input type="submit" value="Undo" class="btn btn-outline-secondary">
	                                </form>
                                </td>
                                
                                <td class="d-flex justify-content-center">
                                	<a href="http://localhost:8090/Computer_Spareparts__MS/UpdateShopItems.jsp?id=${item.itemId}&brand=${item.brandName}&unitprice=${item.unitPrice}&amount=${item.amount}&type=${item.type}">
					                	<input type="submit" value="Update" class="btn btn-info align-middle">
					            	</a>
					            </td>
                                <td>
                                	
	                                <form method="post" action="deleteItemServlet">
	                                	
			                            <input type="hidden" name="itemId" value="${item.itemId}">
			                            <input type="submit" value="Remove" class="btn btn-danger ms-3">
		                                
		                            </form>
	                                
                                </td>
                                
                                
                            </tr>
                                                                           
                            </c:forEach>
                           
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    						<div class="d-flex flex-row mb-3">
    							<div class="p-2">
	                             <a href="http://localhost:8090/Computer_Spareparts__MS/InsertItem.jsp">
						           <button type="button" class="btn btn-primary">Add New Item</button>
						       	 </a>
                            </div>
                            <div class="p-2">
                            <form method="get" action="PDFDownload">
                            	<input type="submit" value="Download Invoice" class="btn btn-primary">
                            </form>
                            	                       	
                            </div>
    						</div>
                            
</div>

 

</section>

</body>
</html>