<%--
  Created by IntelliJ IDEA.
  User: xhj224
  Date: 2016/12/25
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/style.css"/>
    <style>

    </style>
    <script>
        function addAddress() {
            var addressDiv = document.getElementById("new_Address");

            var maskDiv = document.createElement("div");
            maskDiv.id = "mask";
            maskDiv.style.position = "absolute";

            var l = getScrollTop();

            maskDiv.style.top = l + "px";
            maskDiv.style.left = "0";
            var w = document.body.clientWidth;
            var h = document.documentElement.clientHeight;
            maskDiv.style.width = w + "px";
            maskDiv.style.height = h + "px";
            maskDiv.style.zIndex = "2";
            maskDiv.style.backgroundColor = "#CCC";
            maskDiv.style.opacity = "0.5";

            document.body.appendChild(maskDiv);

            addressDiv.style.position = "absolute";
            addressDiv.style.display = "block";
            addressDiv.style.zIndex = "4";
            addressDiv.style.top = (l + 60) + "px";
            addressDiv.style.left = "300px";
        }

        //获得滚动条滚动的距离
        function getScrollTop() {
            var scrollPos;
            if (window.pageYOffset) {
                scrollPos = window.pageYOffset;
            } else if (document.compatMode && document.compatMode != 'BackCompat') {
                scrollPos = document.documentElement.scrollTop;
            } else if (document.body) {
                scrollPos = document.body.scrollTop;
            }
            return scrollPos;
        }

        //关闭添加地址页面
        function closeDiv(obj) {
            var addressDiv = document.getElementById("new_Address");

            var maskDiv = document.getElementById("mask");
            document.body.removeChild(maskDiv);

            addressDiv.style.display = "none";
        }

        function selectLi(num) {
            var lis = document.getElementsByName("address");

            for (var i = 0; i < lis.length; i++) {
                if (i == num) {
                    lis[i].parentNode.style.border = "2px dotted red";
                } else {
                    lis[i].parentNode.style.border = "";
                }
            }

        }


        onload = function () {
            var checks = document.getElementsByName("address");

            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked) {
                    checks[i].parentNode.style.border = "2px dotted red";
                }
            }
        }
    </script>

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
            <div class="address"><span class="title_icon"><img src="${base}/images/bullet1.gif" alt="" title=""/></span>选择送货地址
            </div>

            <div class="address_list" id="address_list">
                <ul>
                    <%--@elvariable id="defaultAddress" type="com.tz.online.entity.address"--%>
                    <c:if test="${!empty defaultAddress}">
                        <li>
                            <input type="radio" name="address" value="${defaultAddress.addressId}" checked
                                   onclick="selectLi(0)">&nbsp;${defaultAddress.area}&nbsp;${defaultAddress.detailAddres}
                            &nbsp;<span style="color:#093">默认地址</span>
                        </li>
                    </c:if>
                    <%--@elvariable id="addressPageing" type="com.tz.online.entity.Pageing"--%>
                    <c:if test="${!empty addressPageing}" var="hasAddress">
                        <c:forEach items="${addressPageing.as}" var="address" varStatus="status">
                            <li>
                                <input type="radio" name="address" value="${address.addressId}" onclick=
                                <c:choose>
                                <c:when test="${empty defaultAddress}">
                                        "selectLi(${status.count-1})"
                                </c:when>
                                <c:otherwise>
                                    "selectLi(${status.count})"
                                </c:otherwise>
                                </c:choose>
                                >&nbsp;${address.area}&nbsp;${address.detailAddres}
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${!hasAddress}">
                        <li>暂无收货地址</li>
                    </c:if>

                    <%--<li><input type="radio" name="address" value="1" onclick="selectLi(0)">&nbsp;江苏省苏州市金阊区烽火路80号 天创大厦4层--%>
                    <%--&nbsp;<span style="color:#093">默认地址</span></li>--%>
                    <%--<li>--%>
                    <%--<input type="radio" name="address" value="1" onclick="selectLi(1)">&nbsp;江苏省苏州市金阊区烽火路80号 天创大厦4层--%>
                    <%--</li>--%>
                    <%--<li><input type="radio" name="address" value="1" onclick="selectLi(2)">&nbsp;江苏省苏州市金阊区烽火路80号 天创大厦4层--%>
                    <%--</li>--%>
                    <%--<li><input type="radio" name="address" value="1" onclick="selectLi(3)">&nbsp;江苏省苏州市金阊区烽火路80号 天创大厦4层--%>
                    <%--</li>--%>
                </ul>
            </div>

            <div class="pagination">
                <c:set var="url" value="${base}/order/balance"/>
                <c:if test="${addressPageing.pageNow>1}">
                    <a href="${url}?pageNow=${addressPageing.pageNow-1}&pageSize=${addressPageing.pageSize}">
                        &lt;&lt;</a>
                </c:if>
                <c:choose>
                    <c:when test="${(addressPageing.pageCount-3)>=0 && addressPageing.pageNow>1}">
                        <c:set var="begin" value="${addressPageing.pageNow-1}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="1"/>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="p" begin="${begin}" end="${begin+2}">
                    <c:if test="${p <= addressPageing.pageCount}">
                        <a href="${url}?pageNow=${p}&pageSize=${addressPageing.pageSize}">${p}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${addressPageing.pageNow != addressPageing.pageCount && addressPageing.pageCount !=0 }">
                    <a href="${url}?pageNow=${addressPageing.pageNow+1}&pageSize=${addressPageing.pageSize}">
                        &gt;&gt;</a>
                </c:if>
            </div>

            <div class="address_new"><input type="button" value="使用新地址" onclick="addAddress()"/></div>

            <div id="new_Address" class="new_Address">
                <div class="closeDiv"><a href="javascript:closeDiv()">X</a></div>

                <div class="address_title">添加收货地址：</div>

                <div class="address_ps"><span style="color:#FC0">新增收货地址</span>　<span style="color:#999; font-size:10px">电话号码、手机号选填一项,其余均为必填项</span>
                </div>

                <div class="newAddress_detail">
                    <form action="${base}/address/saveAddress" method="post">
                        <table>
                            <tr>
                                <td align="right">所在地区：<span style="color:#F00">*</span></td>
                                <td>
                                    <select id="province" name="province" title="" onchange="findCity()" required>
                                        <option>--请选择城市</option>
                                        <%--@elvariable id="provinceList" type="com.tz.online.entity.province"--%>
                                        <c:forEach items="${provinceList}" var="province" varStatus="status">
                                            <option value=${province.provinceCode}>${province.provinceName}</option>
                                        </c:forEach>
                                    </select>
                                    &nbsp;
                                    <select id="city" name="city" title="" onchange="findArea()" required>
                                        <option>--请选择城市--</option>
                                    </select>
                                    &nbsp;
                                    <select id="area" name="area" title="" onchange="findCode()" required>
                                        <option>--请选择区域--</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">详细地址：<span style='color:#F00'>*</span></td>
                                <td>
                                    <textarea name="address_detail" rows="2" cols="23" id="address_detail"
                                              required></textarea>
                                </td>
                            </tr>

                            <tr>
                                <td align="right">邮政编码:<span style="color:#F00">*</span></td>
                                <td>
                                    <input type="text" name="code" id="code" required readonly/>
                                </td>
                            </tr>

                            <tr>
                                <td align="right">收货人姓名:<span style="color:#F00">*</span></td>
                                <td>
                                    <input type="text" name="reciverName" id="reciverName" required/>
                                </td>
                            </tr>

                            <tr>
                                <td align="right">手机号:<span style="color:#F00">*</span></td>
                                <td>
                                    <input type="tel" name="tel" placeholder="请符合手机号规则" id="tel" required/>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2" align="center">
                                    <input type="checkbox" name="defaultAddress" id="defaultAddress" value="1"/>设为默认地址
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2" align="center">
                                    <input style="background-color:orange;color:#FFF;width:70px;" type="submit"
                                           name='button1' value="保存"
                                    <%--onclick="saveAddress()"--%>
                                    />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>


            </div>

            <div class="title"><span class="title_icon"><img src="${base}/images/bullet1.gif" alt="" title=""/></span>我的购物车
            </div>

            <div class="feat_prod_box_details">

                <table class="cart_table">
                    <tr class="cart_title">
                        <td>图片</td>
                        <td>书名</td>
                        <td>单价</td>
                        <td>数量</td>
                        <td>合计</td>
                    </tr>

                    <%--@elvariable id="settlementCart" type="com.tz.online.entity.Cart"--%>
                    <c:forEach items="${settlementCart.items}" var="item">
                        <tr>
                            <td>
                                <a href="${base}/book/detailBook?bookId=${item.book.bookId}">
                                    <img src="${base}/images/${item.book.imgUrl}" width="23" height="35" alt="" title=""
                                         border="0" class="cart_thumb"/>
                                </a>
                            </td>
                            <td>${item.book.bookName}</td>
                            <td>${item.book.price}元</td>
                            <td>${item.count}</td>
                            <td>${item.allPrice}￥</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4" class="cart_total"><span class="red">总价:</span></td>
                        <td>${settlementCart.allPrice}￥</td>
                    </tr>

                    <tr>
                        <td colspan="4" class="cart_total"><span class="red">优惠后:</span></td>
                        <td>${settlementCart.allPrice}￥</td>
                    </tr>

                </table>
                <a href="${base}/cart/viewCart" class="continue">&lt; 返回购物车修改</a>
                <a href="javascript:void(0)" class="checkout" onclick="submitOrder()">提交订单</a>


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
                    <%--@elvariable id="cart" type="com.tz.online.entity.Cart"--%>
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
                href="http://csscreme.com"><img
                src="${base}/images/csscreme.gif" alt="by csscreme.com" title="by csscreme.com" border="0"/></a></div>
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

    function findCity() {
        // 0.清空数据
        document.getElementById("area").length = 1;
        document.getElementById("city").length = 1;
        document.getElementById("code").value = "";

        // 1.获取XMLHttpRequest对象
        var xmlHttp = AjaxFunction();

        // 2.设置请求头
        var provinceCode = document.getElementById("province").value;
        var url = "${base}/ssxjl?action=findCity&provinceCode=" + provinceCode;
        xmlHttp.open("GET", url, true);

        // 4.发送异步请求
        xmlHttp.send();

        // 5.处理来自后台返回的数据
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // 获取响应中的文本
                // var result = xmlHttp.responseText;
                var jsonObj = JSON.parse(xmlHttp.responseText);
                for (var i = 0; i < jsonObj.length; i++) {
                    var option = document.createElement("option");
                    option.value = jsonObj[i].cityCode;
                    option.innerHTML = jsonObj[i].cityName;
                    document.getElementById("city").appendChild(option);
                }
            }
        }
    }

    function findArea() {
        document.getElementById("area").length = 1;
        document.getElementById("code").value = "";
        // 1.获取XMLHttpRequest对象
        var xmlHttp = AjaxFunction();

        // 2.设置请求头
        var cityCode = document.getElementById("city").value;
        var url = "${base}/ssxjl?action=findArea&cityCode=" + cityCode;
        xmlHttp.open("GET", url, true);

        // 4.发送异步请求
        xmlHttp.send();

        // 5。处理来自后台返回的数据
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // 获取响应中的文本
                // var result = xmlHttp.responseText;
                var jsonObj = JSON.parse(xmlHttp.responseText);
                for (var i = 0; i < jsonObj.length; i++) {
                    var option = document.createElement("option");
                    option.value = jsonObj[i].areaCode;
                    option.innerHTML = jsonObj[i].areaName;
                    document.getElementById("area").options[i + 1] = option;
                }
            }
        }
    }

    function findCode() {
        var areaCode = document.getElementById("area").value;
        var code = document.getElementById("code");
        code.value = areaCode;
    }

    function submitOrder() {
        var address = document.getElementsByName("address");
        var addressId = "";
        for (var i = 0; i < address.length; i++) {
            if (address[i].checked) {
                addressId = address[i].value;
            }
        }
        window.location = "${base}/order/saveOrder?addressId=" + addressId;
    }

    //    function saveAddress() {
    //        //        var provinceValue = document.getElementById("province").value;
    //        //        var cityValue = document.getElementById("city").value;
    //        //        var areaValue = document.getElementById("area").value;
    //        //        var addressDetailValue = document.getElementById("address_detail").innerHTML;
    //        //        var xmlHttp = AjaxFunction();
    //        var addressDiv = document.getElementById("new_Address");
    //        var maskDiv = document.getElementById("mask");
    //        document.body.removeChild(maskDiv);
    //
    //        addressDiv.style.display = "none";
    //    }
</script>
</html>
