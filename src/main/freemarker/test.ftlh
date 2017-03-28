<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:
    <a href="${latestProduct.url}">${latestProduct.name}</a>!
  </p>
  <p>
    <ul>
    <#list houses as house>
        <li>${house.address}</li>
    </#list>
    </ul>
  </p>
</body>
</html>
