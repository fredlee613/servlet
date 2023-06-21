<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.Member.Member" %>
<%@ page import="hello.servlet.domain.Member.MemberRepository" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  String name = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(name, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
  <ul>
    <li>id = <%=member.getId()%></li>
    <li>username = <%=member.getUsername()%></li>
    <li>age = <%=member.getAge()%></li>
  </ul>
<a href="/index.html">메인</a>
</body>
</html>