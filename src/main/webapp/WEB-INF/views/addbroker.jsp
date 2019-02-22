<jsp:include page="Includes/header.jsp" />

<div class="content">
    <div class="container-fluid">
        <div class="section-image" data-image="assets/img/bg5.jpg" ;>
            <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-6">
                        <form class="form" method="POST" action="/stockex/addbroker">
                            <div class="card ">
                                <div class="card-header ">
                                    <div class="card-header">
                                        <h4 class="card-title">ADD BROKER</h4>
                                    </div>
                                </div>
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-md-10 pr-1">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input name="email" type="email" class="form-control" value="Enter Email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input name="first_name" type="text" class="form-control" value="Enter First Name" required=true>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-1">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input name="last_name" type="text" class="form-control" value="Enter Last Name"required=true>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>Confirm Password</label>
                                                    <input name="confirm_password" type="password" class="form-control"required=true>
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>Password</label>
                                                    <input name="password" type="password" class="form-control" required=true>
                                                </div>
                                            </div>
                                     </div>
                                     <label style="color:red">${result}</label>
                                        <button type="submit" class="btn btn-info btn-fill pull-right">ADD
                                            Broker Profile</button>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
<jsp:include page="Includes/footer.jsp" />