<jsp:include page="Includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card data-tables">
                        <div class="card-body table-striped table-no-bordered table-hover dataTable dtr-inline table-full-width">
                            <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                            </div>
                            <div class="fresh-datatables">
                                <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>ORDER ID</th>
                                            <th>TYPE</th>
                                            <th>SYMBOL</th>
                                            <th>QTY</th>
                                            <th>ORDER PRICE</th>
                                            <th>TOTAL</th>
                                            <th>DATE</th>
                                            <th>TIME</th>
                                            <th class="disabled-sorting text-right">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orders}" var="item">
                                                <tr>
                                                    <td>${item.getOrderId()}</td>
                                                    <td>${item.getType()}</td>
                                                    <td>${item.getOrderSymbol()}</td>
                                                    <td>${item.getQuantity()}</td>
                                                    <td>$${item.getPrice()}</td>
                                                    <td>$${item.getPrice()*item.getQuantity()}</td>
                                                    <td>${item.getDate()}</td>
                                                    <td>${item.getTime()}</td>
                                                    <td class="text-right">
                                                        <a href="#" class="btn btn-link btn-warning edit"><i class="fa fa-edit"></i></a>
                                                       
                                                        <a href="#" class="btn btn-link btn-danger remove"><i class="fa fa-times"></i></a>
                                                     </td>
                                                </tr>
                                            </c:forEach>
                                    </tbody>
                                </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>
</div>
<jsp:include page="Includes/footer.jsp" />