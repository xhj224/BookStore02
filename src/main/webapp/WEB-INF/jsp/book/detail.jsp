<%--@elvariable id="book" type="com.tz.online.entity.Book"--%>
<%--@elvariable id="tuijianBook" type="com.tz.online.entity.Pageing"--%>
<%-- Created by IntelliJ IDEA. User: xhj224 Date: 2016/12/22 Time: 16:48 To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/style.css"/>
    <link rel="stylesheet" href="${base}/style/lightbox.css" type="text/css" media="screen"/>
    <script src="${base}/js/prototype.js" type="text/javascript"></script>
    <script src="${base}/js/scriptaculous.js?load=effects" type="text/javascript"></script>
    <script src="${base}/js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="${base}/js/java.js"></script>
</head>

<body>
<div id="wrap">
    <div class="header">
        <div class="logo">
            <a href="${base}/book/IndexAction">
                <img src="${base}/images/logo.gif" alt="" title="" border="0"/></a>
        </div>
        <div id="menu">
            <ul>
                <li class="selected">
                    <a href="${base}/book/IndexAction">首页</a></li>
                <li>
                    <a href="${base}/category/showCategory">图书</a></li>
                <li>
                    <a href="${base}/book/viewBookByCate">特价图书</a></li>
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
            <div class="crumb_nav">
                <a href="${base}/book/IndexAction">首页</a>&gt;&gt; ${book.bookName}
            </div>
            <div class="title">
                <span class="title_icon">
                  <img src="${base}/images/bullet1.gif" alt="" title=""/></span>${book.bookName}
            </div>
            <div class="feat_prod_box_details">
                <div class="prod_img">
                    <a href="${base}/book/detailBook">
                        <img src="${base}/images/${book.imgUrl}" alt="" title="" border="0"/></a>
                    <br/>
                    <br/>
                    <a href="${base}/images/big_pic.jpg" rel="lightbox">
                        <img src="${base}/images/zoom.gif" alt="" title="" border="0"/></a>
                </div>
                <div class="prod_det_box">
                    <div class="box_top"></div>
                    <div class="box_center">
                        <div class="prod_title">图书名称:&nbsp;&nbsp;${book.bookName}</div>
                        <p class="details">作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：${book.author}</p>
                        <p class="details">出&nbsp;&nbsp;版&nbsp;&nbsp;社：${book.publish}</p>
                        <p class="details">出版日期：${book.publishDate}</p>
                        <div class="price">
                            <strong>价格:</strong>
                            <span class="red">${book.price}￥</span></div>
                        <c:if test="${!empty userInfo}" var="userCheck">
                            <a href="javascript:void(0)" class="more" onclick="addCart(${book.bookId})">
                                <img src="${base}/images/order_now.gif" alt="" title="" border="0"/>
                            </a>
                        </c:if>
                        <div class="clear"></div>
                    </div>
                    <div class="box_bottom"></div>
                </div>
                <div class="clear"></div>
            </div>
            <div id="demo" class="demolayout">
                <ul id="demo-nav" class="demolayout">
                    <li>
                        <a class="active" href="#tab1">更多信息</a></li>
                    <li>
                        <a class="" href="#tab2">相关图书</a></li>
                </ul>
                <div class="tabs-container">
                    <div style="display: block;" class="tab" id="tab1">
                        <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                            exercitation.</p>
                        <ul class="list">
                            <li>
                                <a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li>
                                <a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li>
                                <a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li>
                                <a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                        </ul>
                        <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                            exercitation.</p></div>

                    <div style="display: none;" class="tab" id="tab2">
                        <%--@elvariable id="bookPageing" type="com.tz.online.entity.Pageing"--%>
                        <c:forEach items="${bookPageing.books}" var="book">
                            <div class="new_prod_box">
                                <a href="${base}/book/detailBook?bookId=${book.bookId}">${book.bookName}</a>
                                <div class="new_prod_bg">
                                    <a href="${base}/book/detailBook?bookId=${book.bookId}">
                                        <img src="${base}/images/${book.imgUrl}" width="60" height="90" alt="" title=""
                                             class="thumb" border="0"/></a>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>


                </div>
            </div>
            <div class="clear"></div>
        </div>
        <!--end of left content-->
        <div class="right_content">
            <div class="languages_box">
                <span class="red">Languages:</span>
                <a href="#">
                    <img src="${base}/images/gb.gif" alt="" title="" border="0"/></a>
                <a href="#">
                    <img src="${base}/images/fr.gif" alt="" title="" border="0"/></a>
                <a href="#">
                    <img src="${base}/images/de.gif" alt="" title="" border="0"/></a>
            </div>
            <div class="currency">
                <span class="red">Currency:</span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#">
                    <strong>USD</strong></a>
            </div>
            <div class="cart">
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/cart.gif" alt="" title=""/>
                  </span>我的购物车
                </div>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <%--@elvariable id="cart" type="com.tz.online.entity.Cart"--%>
                    <div class="home_cart_content">
                        <span id="itemCount">${cart.allcount==null?'0':cart.allcount}件商品</span> |
                        <span id="allPrice" class="red">总价:${cart.allPrice==null?'0.0':cart.allPrice}￥</span>
                    </div>
                    <a href="${base}/cart/viewCart" class="view_cart">查看购物车</a>
                </c:if>
            </div>
            <div class="title">
                <span class="title_icon">
                  <img src="${base}/images/bullet3.gif" alt="" title=""/></span>关于我们店
            </div>
            <div class="about">
                <p>
                    <img src="${base}/images/about.gif" alt="" title="" class="right"/>本书店是天创集团旗下的天智教育经营的书店，开业十年来，一直与国内外五百家出版社，近千家发行单位保持着良好的合作关系。以其集文化传播、艺术鉴赏、休闲为一体的崭新经营方式、一流的购书环境及优质的服务，赢得了众多的荣誉，成为华东地区最大的集图书、音像制品、文化用品、快餐、软件开发、广告策划于一体的图书零售企业。
                </p></div>
            <div class="right_box">
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/bullet4.gif" alt="" title=""/></span>推荐图书
                </div>
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
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/bullet5.gif" alt="" title=""/></span>图书分类
                </div>
                <ul class="list">
                    <li>
                        <a href="#">accesories</a></li>
                    <li>
                        <a href="#">books gifts</a></li>
                    <li>
                        <a href="#">specials</a></li>
                    <li>
                        <a href="#">hollidays gifts</a></li>
                    <li>
                        <a href="#">accesories</a></li>
                    <li>
                        <a href="#">books gifts</a></li>
                    <li>
                        <a href="#">specials</a></li>
                    <li>
                        <a href="#">hollidays gifts</a></li>
                    <li>
                        <a href="#">accesories</a></li>
                    <li>
                        <a href="#">books gifts</a></li>
                    <li>
                        <a href="#">specials</a></li>
                </ul>
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/bullet6.gif" alt="" title=""/></span>合作伙伴
                </div>
                <ul class="list">
                    <li>
                        <a href="#">accesories</a></li>
                    <li>
                        <a href="#">books gifts</a></li>
                    <li>
                        <a href="#">specials</a></li>
                    <li>
                        <a href="#">hollidays gifts</a></li>
                    <li>
                        <a href="#">accesories</a></li>
                    <li>
                        <a href="#">books gifts</a></li>
                    <li>
                        <a href="#">specials</a></li>
                    <li>
                        <a href="#">hollidays gifts</a></li>
                    <li>
                        <a href="#">accesories</a></li>
                </ul>
            </div>
        </div>
        <!--end of right content-->
        <div class="clear"></div>
    </div>
    <!--end of center content-->
    <div class="footer">
        <div class="left_footer">
            <img src="${base}/images/footer_logo.gif" alt="" title=""/>
            <br/>
            <a href="http://csscreme.com">
                <img src="${base}/images/csscreme.gif" alt="by csscreme.com" title="by csscreme.com" border="0"/></a>
        </div>
        <div class="right_footer">
            <a href="${base}/book/IndexAction">home</a>
            <a href="${base}/about/aboutAction">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="${base}/contact/contactAction">contact us</a>
        </div>
</div>
</body>
<script type="text/javascript">
    var tabber1 = new Yetii({
        id: 'demo'
    });

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

    function addCart(id) {
        var xmlHttp = AjaxFunction();
        var url = '${base}/cart/addCart?bookId=' + id;
        xmlHttp.open('get', url, true);
        xmlHttp.send();

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // 获取响应中的文本
                var result = xmlHttp.responseText;
                var arr = result.split(":");
                if (arr[0] == '1') {
                    document.getElementById("itemCount").innerHTML = arr[1] + '件商品';
                    document.getElementById("allPrice").innerHTML = '总价:' + arr[2] + '￥';
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            }
        }
    }
</script>
</html>