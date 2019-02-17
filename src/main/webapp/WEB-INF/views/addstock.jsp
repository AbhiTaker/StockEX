<jsp:include page="Includes/header.jsp" />

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 mr-auto ml-auto">
                <div class="card stacked-form">
                    <div class="card-header ">
                        <h4 class="card-title">Add Stock</h4>
                    </div>
                    <div class="card-body ">
                        <form method="POST" action="/stockex/addstock">
                            <div class="form-group">
                                <label>Stock Symbol</label>
                                <input name="symbol" type="text" placeholder="Enter Symbol" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Company</label>
                                <input name="name" type="text" placeholder="Enter Company" class="form-control">
                            </div>

                             <div class="card-footer ">
                                <button type="submit" class="btn btn-fill btn-info">ADD</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="Includes/footer.jsp" />