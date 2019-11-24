<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<c:set var="sessionUser" value="${sessionScope.sessionUser }"/>

<!doctype html>
<html lang="en">
<head>
    <title>Local Goods | iTec</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
          integrity="sha384-3AB7yXWz4OeoZcPbieVW64vVXEwADiYyAEhwilzWsLw+9FgqpyjjStpPnpBO8o8S" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.css">
</head>

<body class="d-flex flex-column">
<nav class="navbar d-flex flex-column flex-md-row justify-content-between align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <div class="d-flex">
        <a href="/" class="navbar-brand">
            <img class="nav-logo" src="/resources/images/logo.png">
        </a>
    </div>
    <a href="/products/list">Shop now</a>

    <div class="d-flex flex-column flex-md-row align-self-center align-items-center">
        <div class="mr-md-4">
            <c:if test="${not empty sessionOrderEntries}">
                ${sessionOrderEntries.size()}
                <small>items</small>
            </c:if>
            <a class="p-2 text-dark" href="/cart">
                <i class="fas fa-shopping-cart pr-md-2"></i> Place an order
            </a>
        </div>

        <c:choose>
            <c:when test="${empty sessionUser.name}">
                <div class="p-2">
                    <a class="btn btn-outline-primary" href="/login">Login</a>
                </div>
                <div class="p-2">
                    <a class="btn btn-outline-primary" href="/register">Register</a>
                </div>
            </c:when>
            <c:otherwise>
                <h6 class="mr-md-3 d-none d-md-block">|</h6>
                <div class="dropdown mr-md-4">
                    <span class="dropdown-toggle" id="userpanel-dropdown" data-toggle="dropdown" aria-haspopup="true"
                          aria-expanded="false">
                                        Welcome <b class="pr-2 my-2 my-md-0"> ${sessionUser.name}</b>
                    </span>
                    <div class="dropdown-menu" aria-labelledby="userpanel-dropdown">
                        <c:choose>
                            <c:when test="${!sessionUser.isSeller}">
                                <a class="dropdown-item" href="/orders/history"><span class="oi oi-timer"> Orders history</a>
                            </c:when>
                            <c:otherwise>
                                <a class="dropdown-item" href="/products/add"><span class="oi oi-plus"></span> Add new product</a>
                                <a class="dropdown-item" href="/orders/to-be-delivered"><span class="oi oi-timer"></span> Orders to deliver</a>
                                <a class="dropdown-item" href="/orders/seller-history"><span class="oi oi-header"></span></span> History of delivers</a>
                            </c:otherwise>
                        </c:choose>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/user/account"><span class="oi oi-person"></span> My profile</a>
                    </div>
                </div>
                <a class="btn btn-outline-primary" href="/logout"><span class="oi oi-power-standby"></span> Logout</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>