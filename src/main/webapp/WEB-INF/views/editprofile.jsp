<jsp:include page="Includes/header.jsp" />

<div class="content">
    <div class="container-fluid">
        <div class="section-image" data-image="assets/img/bg5.jpg" ;>
            <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-6">
                        <form class="form" method="POST" action="/stockex/editprofile">
                            <div class="card ">
                                <div class="card-header ">
                                    <div class="card-header">
                                        <h4 class="card-title">Edit Profile</h4>
                                    </div>
                                </div>
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-md-5 pr-1">
                                            <div class="form-group">
                                                <label>User (disabled)</label>
                                                <input name="usertype" type="text" class="form-control" disabled="" value="${usertype}">
                                            </div>
                                        </div>
                                        <div class="col-md-7 pl-1">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input type="email" class="form-control" disabled="" value="${email}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input name="first_name" type="text" class="form-control" value="${first_name}" required=true>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-1">
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input name="last_name" type="text" class="form-control" value="${last_name}" required=true>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                            <div class="col-md-6 pr-1">
                                                <div class="form-group">
                                                    <label>New Password</label>
                                                    <input name="new_password" type="password" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-md-6 pl-1">
                                                <div class="form-group">
                                                    <label>Current Password</label>
                                                    <input name="password" type="password" class="form-control" required=true>
                                                </div>
                                            </div>
                                     </div>
                                        
                                        <button type="submit" class="btn btn-info btn-fill pull-right">Update
                                            Profile</button>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                        </form>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="card-header no-padding">
                                <div class="card-image">
                                    <img src="assets/img/full-screen-image-3.jpg" alt="...">
                                </div>
                            </div>
                            <div class="card-body ">
                                <div class="author">
                                    <a href="#">
                                        <img class="avatar border-gray" src="assets/img/tim_80x80.png" alt="...">
                                        <h5 class="card-title">${first_name} ${last_name}</h5>
                                    </a>
                                    <p class="card-description">
                                        ${usertype}
                                    </p>
                                </div>
                                <!--
                                                <p class="card-description text-center">
                                                    Hey there! As you can see,
                                                    <br> it is already looking great.
                                                </p>
                                            -->
                            </div>
                            <div class="card-footer ">
                                <hr>
                                <div class="button-container text-center">
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-facebook-square"></i>
                                    </button>
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-twitter"></i>
                                    </button>
                                    <button href="#" class="btn btn-simple btn-link btn-icon">
                                        <i class="fa fa-google-plus-square"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
<jsp:include page="Includes/footer.jsp" />