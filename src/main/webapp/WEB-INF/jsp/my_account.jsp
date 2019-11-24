<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="col-md-9">
    <div class="card-body">
        <div class="row">
            <div class="col-md-12">
                <h1>My profile</h1>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form:form method="post" action="/user/account" modelAttribute="userInfoForm">
                    <div class="form-group row">
                        <label for="name" class="col-4 col-form-label">Name</label>
                        <div class="col-8">
                            <form:input id="name" name="name" placeholder="Name" class="form-control here"
                                        type="text" path="name" value="${userDetails.name}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="text" class="col-4 col-form-label">Phone</label>
                        <div class="col-8">
                            <form:input id="text" name="text" placeholder="Phone" class="form-control here"
                                        required="required" type="text" path="phone" value="${userDetails.phone}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email" class="col-4 col-form-label">Email</label>
                        <div class="col-8">
                            <form:input id="email" name="email" placeholder="Email" class="form-control here"
                                        required="required" type="text" path="email" value="${userDetails.email}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="oldPassword" class="col-4 col-form-label">Password</label>
                        <div class="col-8">
                            <form:input path="oldPassword" id="oldPassword" name="oldPassword"
                                        placeholder="Old password" class="form-control here"
                                        type="text"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newPassword" class="col-4 col-form-label"></label>
                        <div class="col-8">
                            <form:input path="newPassword" id="newPassword" name="newPassword"
                                        placeholder="New password" class="form-control here"
                                        type="text"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newpass" class="col-4 col-form-label">Address</label>
                        <div class="col-8">
                            <form:input path="city" id="city" name="city" placeholder="City"
                                        class="form-control here"
                                        type="text" value="${userDetails.address.city}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newpass" class="col-4 col-form-label"></label>
                        <div class="col-8">
                            <form:input path="street" id="street" name="street" placeholder="Street"
                                        class="form-control here"
                                        type="text" value="${userDetails.address.street}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newpass" class="col-4 col-form-label"></label>
                        <div class="col-8">
                            <form:input path="number" id="number" name="number" placeholder="Number"
                                        class="form-control here"
                                        type="text" value="${userDetails.address.number}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="submit" class="btn btn-primary">Update My Profile</button>
                        </div>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>