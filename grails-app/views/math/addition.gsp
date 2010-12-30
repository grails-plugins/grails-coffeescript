<html>
<head>
</head>
<body>
    <coffee:inline>
        window.addNumbers = (x, y) -> result = Number(x) + Number(y);
        msg = x + " + " + y + " is " + result;
        document.all.result.innerText = msg
    </coffee:inline>
    <form name="additionForm">
        X = <g:textField name="x" value="" />,
        Y = <g:textField name="y" value="" />
        <input type="button" value="Add" onclick="addNumbers(x.value, y.value)" />
    </form>
    <div id="result"></div>
</body>
</html>