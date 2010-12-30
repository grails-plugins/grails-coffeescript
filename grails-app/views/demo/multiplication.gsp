<html>
<head>
    <coffee:script name="math"/>
</head>
<body>
    <form name="multiplicationForm">
        X = <g:textField name="x" value="" />,
        Y = <g:textField name="y" value="" />
        <input type="button" value="Multiply" onclick="document.all.result.innerText=multiplyNumbers(x.value, y.value)" />
    </form>
    <div id="result"></div>
    
</body>
</html>