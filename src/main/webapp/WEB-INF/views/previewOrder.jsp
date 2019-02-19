<jsp:include page="Includes/header.jsp" />

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <div class="card stacked-form">
                    <div class="card-header ">
                        <h4 class="card-title">YOUR ORDER</h4>
                    </div>
                    <div class="card-body ">
                        <form method="POST" action="/stockex/previewOrder">
                            <div class="form-group">
                                <label>Quantity</label>
                                <input name="quantity" type="text" value="${order.getQuantity()}" disabled="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Price($) </label>
                                <input name="price" type="text" value="${order.getPrice()}" disabled="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Price($) </label>
                                <input name="commission" type="text" value="${order.getCommission()}" disabled="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Total($) </label>
                                <input name="total" type="text" value="${order.getTotal()}" disabled="" class="form-control">
                            </div>

                             <div class="card-footer ">
                                <button type="submit" class="btn btn-fill btn-info">Order</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                    <div class="card stacked-form">
                        <div class="card-header ">
                            <h4 class="card-title">${stock.getName()}</h4>
                        </div>
                        <div class="card-body ">
                                <div class="form-group">
                                    <label>Stock Symbol : </label>
                                    <label><h5>${stock.getSymbol()}</h5></label>
                                </div>
                                <div class="form-group">
                                    <label>Current Price ($): </label>
                                    <label><h5>$${stock.getPrice()}</h5></label>
                                 </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>
<jsp:include page="Includes/footer.jsp" />