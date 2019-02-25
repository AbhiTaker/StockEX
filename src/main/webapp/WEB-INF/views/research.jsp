<jsp:include page="Includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card bootstrap-table">
                    <div class="card-body table-full-width">
                        <div class="toolbar">
                            <!--        Here you can write extra buttons/actions for the toolbar              -->
                        </div>
                        <table id="bootstrap-table" class="table">
                            <thead>
                                <th data-field="symbol" data-sortable="true">Symbol</th>
                                <th data-field="company" data-sortable="true">Company</th>
                                <th data-field="price" data-sortable="true">Stock Price</th>
                                <th data-field="actions" class="td-actions text-right" data-events="operateEvents" data-formatter="operateFormatter">Actions</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${stocks}" var="item">
                                    <tr>
                                        <td>${item.getSymbol()}</td>
                                        <td>${item.getName()}</td>
                                        <td>$${item.getPrice()}</td>
                                        <td></td>
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
<jsp:include page="Includes/footer.jsp" />