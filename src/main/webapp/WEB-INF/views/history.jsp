
<jsp:include page="Includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container-fluid">
        <div class="col-md-12">
                <div class="card data-tables">
                    <div class="card-body table-striped table-no-bordered table-hover dataTable dtr-inline table-full-width">
                        <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                        </div>

                        <label><h3  style="text-align:center;  margin: 30px 15px">HISTORY</h3></label>
                        <div class="fresh-datatables">
                            <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>SYMBOL</th>
                                        <th>QTY</th>
                                        <th>PURCHASE PRICE</th>
                                        <th>TOTAL VALUE</th>
                                        <th>ORDER DATE</th>
                                        <th>ORDER TIME</th>
                                        <th class="disabled-sorting text-right">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orders}" var="item">
                                        <tr>
                                            <td>${item.getOrderSymbol()}</td>
                                            <td>${item.getQuantity()}</td>
                                            <td>$${item.getPrice()}</td>
                                            <td>$${item.getPrice()*item.getQuantity()}</td>
                                            <td>${item.getDate()}</td>
                                            <td>${item.getTime()}</td>
                                            <td class="text-right">
                                                <a href="#" class="btn btn-link btn-info like"><i class="fa fa-heart"></i></a>
                                                <a href="#" class="btn btn-link btn-warning edit"><i class="fa fa-edit"></i></a>
                                                <a href="#" class="btn btn-link btn-danger remove"><i class="fa fa-times"></i></a>
                                             </td>
                                        </tr>
                                    </c:forEach>
                                    
                                </tbody>
        
        
                                <!--
                                <tfoot>
                                    <tr>
                                        <th>SYMBOL</th>
                                        <th>COMPANY</th>
                                        <th>QTY</th>
                                        <th>PURCHASE PRICE</th>
                                        <th>CURRENT PRICE</th>
                                        <th>TOTAL VALUE</th>
                                        <th>GAIN / LOSS</th>
                                        <th class="text-right">Actions</th>
                                    </tr>
                                </tfoot>
                            -->
                            </table>
                        </div>
                     </div>
                    </div>
                </div>
    </div>
</div>
<jsp:include page="Includes/footer.jsp" />