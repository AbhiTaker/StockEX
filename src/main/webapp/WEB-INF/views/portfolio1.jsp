
<jsp:include page="Includes/header.jsp" />


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 col-sm-6">
                <div class="card card-stats">
                    <div class="card-body ">
                        <div class="row">
                            <div class="col-5">
                                <div class="icon-big text-center icon-warning">
                        <i class="nc-icon nc-bank text-warning"></i>
                                </div>
                            </div>
                            <div class="col-7">
                                <div class="numbers">
                        <p class="card-category">Account Value</p>
                        <h4 class="card-title">$${account.getValue()}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer ">
                        <hr>
                        <div class="stats">
                            <i class="nc-icon nc-bank"></i> Current
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="card card-stats">
                    <div class="card-body ">
                        <div class="row">
                            <div class="col-5">
                                <div class="icon-big text-center icon-warning">
                        <i class="nc-icon nc-money-coins text-success"></i>
                                </div>
                            </div>
                            <div class="col-7">
                                <div class="numbers">
                        <p class="card-category">Cash</p>
                        <h4 class="card-title">$${account.getCash()}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer ">
                        <hr>
                        <div class="stats">
                            <i class="nc-icon nc-money-coins"></i> Last day
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="card card-stats">
                    <div class="card-body ">
                        <div class="row">
                            <div class="col-5">
                                <div class="icon-big text-center icon-warning">
                        <i class="nc-icon nc-cart-simple text-danger"></i>
                                </div>
                            </div>
                            <div class="col-7">
                                <div class="numbers">
                        <p class="card-category">Buying Power</p>
                        <h4 class="card-title">$${account.getBuying_power()}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer ">
                        <hr>
                        <div class="stats">
                            <i class="nc-icon nc-cart-simple"></i> In the last hour
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="card card-stats">
                    <div class="card-body ">
                        <div class="row">
                            <div class="col-5">
                                <div class="icon-big text-center icon-warning">
                        <i class="nc-icon nc-satisfied text-primary"></i>
                                </div>
                            </div>
                            <div class="col-7">
                                <div class="numbers">
                        <p class="card-category">Annual Returns</p>
                        <h4 class="card-title">0 %</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer ">
                        <hr>
                        <div class="stats">
                            <i class="nc-icon nc-satisfied"></i> Update now
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <h3>STOCK PORTFOLIO</h3>
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
                                <th>SYMBOL</th>
                                <th>COMPANY</th>
                                <th>QTY</th>
                                <th>PURCHASE PRICE</th>
                                <th>CURRENT PRICE</th>
                                <th>TOTAL VALUE</th>
                                <th>GAIN / LOSS</th>
                                <th class="disabled-sorting text-right">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:when test="${not empty orders}">
                            <c:forEach items="${orders}" var="item">
                                <tr>
                                      
                                    <td>${item.getCompany()}</td>
                                    <td>${item.getQuantity()}</td>
                                    <td>$${item.getPrice()}</td>
                                    <td>${item.getDate()}</td>
                                    <td>${item.getTime()}</td>
                                    <td>what </td>
                                    <td class="text-right">
                                        <a href="#" class="btn btn-link btn-info like"><i class="fa fa-heart"></i></a>
                                        <a href="#" class="btn btn-link btn-warning edit"><i class="fa fa-edit"></i></a>
                                        <a href="#" class="btn btn-link btn-danger remove"><i class="fa fa-times"></i></a>
                                     </td>
                                </tr>
                            </c:forEach>
                            </c:when>

                            <c:forEach items="${orders2}" var="item">
                                <tr>
                                    
                                    <td>${item.getSymbol()}</td>   
                                    <td>${item.geCompany()}</td>
                                    <td>${item.getQuantity()}</td>
                                    <td>$${item.getPrice()}</td>
                                    <td>${item.getDate()}</td>
                                    <td>${item.getTime()}</td>
                                    <td>what </td>
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