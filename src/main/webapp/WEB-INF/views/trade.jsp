<jsp:include page="Includes/header.jsp" />


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <div class="card stacked-form">
                    <div class="card-header ">
                        <h4 class="card-title">Order Stock</h4>
                    </div>
                    <div class="card-body ">
                        <form id="TypeValidation" class="form-horizontal" method="POST" action="/stockex/trade">
                            <div class="form-group">
                                <label>STOCK SYMBOL</label>
                                <input name="symbol" type="text" placeholder="Enter Symbol" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>TRANSACTION</label>
                                <select name="transaction" class="form-control">
                                    <option value="buy" name="admin">BUY</option>
                                    <option value="sell" name="broker">SELL</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>QUANTITY</label>
                                <input name="quantity" type="text" placeholder="Enter Quantity" class="form-control" number="true">
                            </div>
                            <div class="form-group">
                                <label>PRICE</label>
                                <input name="price" type="text" placeholder="Enter Quantity" class="form-control" number="true">
                            </div>

                             <div class="card-footer ">
                                <button type="submit" class="btn btn-fill btn-info">PREVIEW ORDER</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="Includes/footer.jsp" />