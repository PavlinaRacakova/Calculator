[#ftl]
[#import "/spring.ftl" as spring]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/mainPage" method="post" class="calculator-form">

        <div class="form-group">
            <label for="firstNumber">First Number</label>
            <input type="text" class="form-control" name="firstNumber" id="firstNumber" value=${mathOperation.firstNumber!0}>
            [@spring.bind "mathOperation.firstNumber"/]
            <div class="error">[@spring.showErrors "<br>"/]</div>
        </div>

        <div class="form-group">
            <label for="secondNumber">Second Number</label>
            <input type="text" class="form-control" name="secondNumber" id="secondNumber" value=${mathOperation.secondNumber!0}>
            [@spring.bind "mathOperation.secondNumber"/]
            <div class="error">[@spring.showErrors "<br>"/]</div>
        </div>

        <div class="mb-3">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-check">
                        <input id="addition" type="radio" class="form-check-input" name="operation" value="ADDITION"/>
                        <label class="form-check-label" for="addition">Addition</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-check">
                        <input id="subtraction" type="radio" class="form-check-input" name="operation"
                               value="SUBTRACTION"/>
                        <label class="form-check-label" for="subtraction">Subtraction</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-check">
                        <input id="multiplication" type="radio" class="form-check-input" name="operation"
                               value="MULTIPLICATION"/>
                        <label class="form-check-label" for="multiplication">Multiplication</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-check">
                        <input id="division" type="radio" class="form-check-input" name="operation" value="DIVISION"/>
                        <label class="form-check-label" for="division">Division</label>
                    </div>
                </div>
            </div>
        </div>
        [@spring.bind "mathOperation.operation"/]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <div class="text-center">
            <button class="btn btn-primary" type="submit">Calculate</button>
        </div>

        <div class="result-container">
            <input type="hidden" name="result" value="${mathOperation.result!}"/>
            <h2 class="result-text">${mathOperation.result!}</h2>
        </div>
    </form>
</div>
</body>
</html>