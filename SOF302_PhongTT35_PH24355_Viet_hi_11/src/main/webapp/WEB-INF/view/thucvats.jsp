<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form action="/thuc-vat/" method="post">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>

    </form>
    <br/>
    <br/>
    <form action="/thuc-vat/add" method="post">


        <br/>
        <br/>
        Ma: <input type="text" name="ma"/>

        <br/>
        <br/>
        Tên: <input type="text" name="ten"  />

        <br/>
        <br/>
        Loai:
        <Select name="loai" >
            <option>Loai 1</option>
            <option>Loai 2</option>
            <option>Loai 3</option>
            <option>Loai 4</option>
        </Select>

        <br/>
        <br/>
        chieu Cao: <input type="text" name="chieuCao" />
        <br/>
        gioiTinh: <input type="radio" name="gioiTinh" />
        <input type="radio" name="gioiTinh"/>

        <br/>
        <button type="submit">Add</button>
    </form>

    <tr>

        <th>Ma</th>
        <th>Ten</th>
        <th>Loai</th>
        <th>ChieuCao</th>
        <th>GioiTinh</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach var="sp" items="${list}">

        <td>
                ${sp.ma}
        </td>
        <td>
                ${sp.ten}
        </td>
        <td>
                ${sp.loai}
        </td>
        <td>
                ${sp.chieuCao}
        </td>
        <td>
                ${sp.gioiTinh}
        </td>
        <td>

            <button> <a href="/thuc-vat/remove/${sp.ma}">Remove</a> </button>
            <button> <a href="/thuc-vat/view-update/${sp.ma}">Update</a> </button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>