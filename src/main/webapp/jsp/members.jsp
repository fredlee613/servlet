<%@ page import="hello.servlet.domain.Member.MemberRepository" %>
<%@ page import="hello.servlet.domain.Member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
<%
  for (Member member : members) {
    out.print("    <tr>");
    out.print("        <td>" + member.getId() + "</td>");
    out.print("        <td>" + member.getUsername() + "</td>");
    out.print("        <td>" + member.getAge() + "</td>");
    out.print("    <tr>");
  }
%>
  </tbody>
</table>
</body>
</html>
