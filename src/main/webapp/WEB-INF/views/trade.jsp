<jsp:include page="Includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                                <label>COMPANY</label>
                                <select name="symbol" class="form-control">
                                    <c:forEach items="${stockList}" var="item">
                                        <option value="${item.getSymbol()}">${item.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>TRANSACTION</label>
                                <select name="type" class="form-control">
                                    <option name="buy">BUY</option>
                                    <option name="sell">SELL</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>QUANTITY</label>
                                <input name="quantity" type="text" placeholder="Enter Quantity" class="form-control" number="true" required="true">
                            </div>
                            <div class="form-group">
                                <label>PRICE ($)</label>
                                <input name="price" type="text" placeholder="Enter Quantity" class="form-control" number="true" required="true">
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