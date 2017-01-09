<%--
  Created by IntelliJ IDEA.
  User: xhj224
  Date: 2016/12/24
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/style.css"/>
</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo"><a href="${base}/book/IndexAction"><img src="${base}/images/logo.gif" alt="" title=""
                                                                  border="0"/></a></div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="${base}/book/IndexAction">首页</a></li>

                <li><a href="${base}/category/showCategory">图书</a></li>
                <li><a href="${base}/book/viewBookByCate">特价图书</a></li>
                <c:if test="${empty userInfo}" var="userCheck">
                    <li><a href="${base}/user/login">登陆</a></li>
                    <li><a href="${base}/user/register">注册</a></li>
                </c:if>
                <c:if test="${!userCheck}">
                    <li><a href="${base}/user/exit">注销</a></li>
                </c:if>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <li><a href="${base}/order/orderList">我的订单</a></li>
                </c:if>
                <li><a href="${base}/about/aboutAction">关于我们</a></li>
                <li><a href="${base}/contact/contactAction">联系我们</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="title"><span class="title_icon"><img src="${base}/images/bullet1.gif" alt="" title=""/></span>我的购物车
            </div>

            <div class="feat_prod_box_details">

                <table class="cart_table">
                    <tr class="cart_title">
                        <td><input type="checkbox" id="checkAll" onchange="selectAllOrNot(this)"/></td>
                        <td>图片</td>
                        <td>书名</td>
                        <td>单价</td>
                        <td>数量</td>
                        <td>合计</td>
                    </tr>

                    <%--@elvariable id="cart" type="com.tz.online.entity.Cart"--%>
                    <c:forEach items="${cart.items}" var="item">
                        <tr>
                            <td><input type="checkbox" name="itemCheck" value="${item.book.bookId}"/></td>
                            <td>
                                <a href="${base}/book/detailBook?bookId=${item.book.bookId}">
                                    <img src="${base}/images/${item.book.imgUrl}" width="23" height="35" alt="" title=""
                                         border="0" class="cart_thumb"/>
                                </a>
                            </td>
                            <td>${item.book.bookName}</td>
                            <td>${item.book.price}元</td>
                            <td><input onblur="modifyItem('${item.book.bookId}',this)" type="text" name="count"
                                       value="${item.count}" style="width:30px; text-align:center"/></td>
                            <td>${item.allPrice}￥</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4" class="cart_total"><span class="red">总价:</span></td>
                        <td id="allPriceA">${cart.allPrice}￥</td>
                    </tr>


                </table>
                <a href="${base}/book/IndexAction" class="continue">&lt;&lt;继续买</a>
                <a href="javascript:void(0)" onclick="balanceItem()" class="checkout">结算</a>
                <a href="javascript:void(0)" onclick="clearCart()" class="checkout">清空</a>
                <a href="javascript:void(0)" onclick="removeCart()" class="checkout">删除</a>
            </div>


            <div class="clear"></div>
        </div><!--end of left content-->

        <div class="right_content">

            <div class="languages_box">
                <span class="red">Languages:</span>
                <a href="#"><img src="${base}/images/gb.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/fr.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/de.gif" alt="" title="" border="0"/></a>
            </div>
            <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
            </div>


            <div class="cart">
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/cart.gif" alt="" title=""/>
                  </span>我的购物车
                </div>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <div class="home_cart_content">
                        <span id="itemCount">${cart.allcount==null?'0':cart.allcount}件商品</span> |
                        <span id="allPrice" class="red">总价:${cart.allPrice==null?'0.0':cart.allPrice}￥</span>
                    </div>
                    <a href="${base}/cart/viewCart" class="view_cart">查看购物车</a>
                </c:if>
            </div>

            <div class="title"><span class="title_icon"><img src="${base}/images/bullet3.gif" alt="" title=""/></span>关于我们店
            </div>
            <div class="about">
                <p>
                    <img src="${base}/images/about.gif" alt="" title="" class="right"/>
                    本书店是天创集团旗下的天智教育经营的书店，开业十年来，一直与国内外五百家出版社，近千家发行单位保持着良好的合作关系。以其集文化传播、艺术鉴赏、休闲为一体的崭新经营方式、一流的购书环境及优质的服务，赢得了众多的荣誉，成为华东地区最大的集图书、音像制品、文化用品、快餐、软件开发、广告策划于一体的图书零售企业。
                </p>

            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet4.gif" alt=""
                                                                 title=""/></span>推荐图书
                </div>
                <%--@elvariable id="tuijianBook" type="com.tz.online.entity.Pageing"--%>
                <c:forEach items="${tuijianBook.books}" var="book">
                    <div class="new_prod_box">
                        <a href="${base}/book/detailBook?bookId=${book.bookId}">${book.bookName}</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="${base}/images/promo_icon.gif" alt="" title=""/>
                            </span>
                            <a href="${base}/book/detailBook?bookId=${book.bookId}">
                                <img src="${base}/images/${book.imgUrl}" width="60" height="90" alt="" title=""
                                     class="thumb" border="0"/>
                            </a>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet5.gif" alt=""
                                                                 title=""/></span>图书分类
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                </ul>

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet6.gif" alt=""
                                                                 title=""/></span>合作伙伴
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                </ul>

            </div>


        </div><!--end of right content-->


        <div class="clear"></div>
    </div><!--end of center content-->


    <div class="footer">
        <div class="left_footer"><img src="${base}/images/footer_logo.gif" alt="" title=""/><br/> <a
                href="http://csscreme.com"><img src="${base}/images/csscreme.gif" alt="by csscreme.com"
                                                title="by csscreme.com" border="0"/></a></div>
        <div class="right_footer">
            <a href="${base}/book/IndexAction">home</a>
            <a href="${base}/about/aboutAction">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="${base}/contact/contactAction">contact us</a>
        </div>


    </div>


</div>

</body>
<script>
    function AjaxFunction() {
        var xmlHttp;  // 缓存XHR对象便于 Ajax 使用
        try {
            xmlHttp = new XMLHttpRequest(); // Opera 8.0+, Firefox, Safari
        } catch (e) {
            // Internet Explorer Browsers
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    // 错误处理
                    alert("Your browser broke!");
                }
            }
        }
        return xmlHttp;
    }

    function modifyItem(id, obj) {
        var count = obj.value;
        if (/^[1-9]\d*$/.test(count)) {
            var xmlHttp = AjaxFunction();
            var url = '${base}/cart/modifyCart?bookId=' + id + "&count=" + count;
            xmlHttp.open("get", url, this);
            xmlHttp.send();

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    // 获取响应中的文本
                    var result = xmlHttp.responseText;
                    if (result == '1') {
                        alert("成功修改!!!");
                        location.reload();
                    }
                }
            }
        } else {
            alert("数字格式不对")
        }
    }

    function clearCart() {
        var xmlHttp = AjaxFunction();
        var url = '${base}/cart/clearCart';
        xmlHttp.open("get", url, this);
        xmlHttp.send();

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // 获取响应中的文本
                var result = xmlHttp.responseText;
                if (result == '1') {
                    document.getElementById("itemCount").innerHTML = 0 + '件商品';
                    document.getElementById("allPrice").innerHTML = '总价:' + 0.0 + '￥';
                    document.getElementById("allPriceA").innerHTML = 0.0 + '￥';
                    var tbody = document.getElementsByTagName("tbody")[0];
                    var checkBoxs = document.getElementsByName("itemCheck");
                    for (var i = checkBoxs.length - 1; i >= 0; i--) {
                        tbody.removeChild(checkBoxs[i].parentNode.parentNode);
                    }
                    document.getElementById("checkAll").checked = false;
                    alert("清空成功");
                    // location.reload();
                } else {
                    alert("清空失败")
                }
            }
        }
    }

    function removeCart() {
        var ids = "";
        var count = 0;
        var checks = document.getElementsByName("itemCheck");
        for (var i = 0; i < checks.length; i++) {
            if (checks[i].checked) {
                count += 1;
                ids += checks[i].value + ":";
            }
        }

        if (count < 1) {
            alert("至少选中一个商品!!!");
        } else {
            var xmlHttp = AjaxFunction();
            var url = '${base}/cart/removeCart?ids=' + ids;
            xmlHttp.open("get", url, this);
            xmlHttp.send();

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    // 获取响应中的文本
                    var result = xmlHttp.responseText;
                    if (result == '1') {
                        alert("成功删除!!!");
                        location = "${base}/cart/viewCart";
                    }
                }
            }
        }
    }

    function selectAllOrNot(obj) {
        if (obj.checked) {
            var checks2 = document.getElementsByName("itemCheck");
            for (var j = 0; j < checks2.length; j++) {
                if (!checks2[j].checked) {
                    checks2[j].checked = true;
                }
            }
        } else {
            var checks = document.getElementsByName("itemCheck");
            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked) {
                    checks[i].checked = false;
                }
            }
        }
    }

    function balanceItem() {
        var count = 0;
        var ids = "";
        var checks = document.getElementsByName("itemCheck");
        for (var i = 0; i < checks.length; i++) {
            if (checks[i].checked) {
                count += 1;
                ids += checks[i].value + ":";
            }
        }

        if (count > 0) {
            window.location = "${base}/order/balance?ids=" + ids;
        } else {
            alert("请至少选中一个商品!");
        }
    }
</script>
</html>
