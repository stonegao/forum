<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Welcome</title>
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
    <script src="<c:url value="/static/jsquery/jquery.js"/>"></script>
    <script src="<c:url value="/static/javascript/knockout-2.1.0.js"/>"></script>

</head>
<body class="home">
<%@ include file="registerHeader.jsp" %>

<div class="title">
    <span><h1>The Forum</h1></span>
</div>

<div class ="activityWall" style="width:500px; border:1px solid black;">
    <p data-bind="foreach: questions">
     <a data-bind="attr: {href: url }">
        <span data-bind="text: title" > </span>
     </a>
        <span data-bind="text: createdAt"> </span>
        <br />
        <span data-bind="text: description"> </span>
        <br />
        <span data-bind="text: userId"> </span>
        <br /><br />
    </p>
    <button data-bind="click: loadMoreQuestion">more..</button>
    <script src="<c:url value="/static/javascript/moreQuestionsLoader.js"/>"></script>
    <br /><br />
</div>
    <div id='fb-root'></div>
    <p id='msg'></p>

<p style="cursor:hand"><a onclick='postToFeed(); return false;'><img src="<c:url value="static/CLEditor1_3_0/images/facebookShare.jpg"/>" alt="Facebook" class="Facebook Icon" height="50" width="50"></a></p>

<p><a href="https://twitter.com/share" class="twitter-share-button" data-text="Visit the forum for info on Bangalore -&gt; http://localhost:8080/app" data-size="large" data-count="none">Tweet</a></p>

</body>
</html>

