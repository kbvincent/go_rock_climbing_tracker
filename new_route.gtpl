<html>
    <head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <form action="/log_route" method="post" class="newRoute">
            <div class="form-group">
              <label for="participant">Participant: </label>
              <input type="text" class="form-control" name="participant">
            </div>
            <div class="form-group">
              <label for="routeType">Route Type: </label>
              <select class="form-control" id="routeType" name="routeType">
                <option disabled="true" selected="selected" >Select Route Type</option>
                <option value="boulder">Bouldering</option>
                <option value="top_rope">Top-Rope</option>
                <option value="lead_climb">Lead Climb</option>
              </select>
            </div>
            <div class="form-group">
              <label for="difficulty">Difficulty</label>
              <select class="form-control" id="difficulty" name="difficulty">
                <option disabled="true" selected="selected">Select Difficulty</option>
                <option value="0.0">v0</option>
                <option value="0.1">v1</option>
                <option value="0.2">v2</option>
                <option value="0.3">v3</option>
                <option value="0.4">v4</option>
                <option value="0.5">v5</option>
                <option value="0.6">v6</option>
                <option value="0.7">v7</option>
                <option value="0.8">v8</option>
                <option value="0.9">v9</option>
                <option value="0.10">v10</option>
                <option value="0.11">v11</option>
                <option value="0.12">v12</option>
                <option value="5.4">4</option>
                <option value="5.5">5</option>
                <option value="5.6">6</option>
                <option value="5.7">7</option>
                <option value="5.8">8</option>
                <option value="5.9">9</option>
                <option value="5.101">10a</option>
                <option value="5.102">10b</option>
                <option value="5.103">10c</option>
                <option value="5.104">10d</option>
                <option value="5.111">11a</option>
                <option value="5.112">11b</option>
                <option value="5.113">11c</option>
                <option value="5.114">11d</option>
                <option value="5.121">12a</option>
                <option value="5.122">12b</option>
                <option value="5.123">12c</option>
                <option value="5.124">12d</option>
                <option value="5.131">13a</option>
                <option value="5.132">13b</option>
                <option value="5.133">13c</option>
                <option value="5.134">13d</option>
                <option value="5.141">14a</option>
                <option value="5.142">14b</option>
                <option value="5.143">14c</option>
                <option value="5.144">14d</option>
              </select>
            </div>
            <div class="form-group">
              <label for="color">Route Color: </label>
              <select class="form-control" id="color" name="color">
                <option value="black" style="color: black;">Black</option>
                <option value="blue" style="color: blue;">Blue</option>
                <option value="green" style="color: green;">Green</option>
                <option value="purple" style="color: purple;">Purple</option>
                <option value="red" style="color: red;">Red</option>
                <option value="white" style="color: white;">White</option>
                <option value="yellow" style="color: yellow;">Yellow</option>
              </select>
            </div>
            <div class="form-group">
              <label for="comments">Comments: </label>
              <input type="text" class="form-control" name="comments">
            </div>
            <input type="submit" value="Log Climb">
        </form>
        <script>
        $("#routeType").change(function() {
          if ($("#routeType").val() == 'boulder') {
            $("#difficulty option[value]").filter(function() {
              return +$(this).val() > 2;
            }).hide();
            $("#difficulty option[value]").filter(function() {
              return +$(this).val() < 2;
            }).show();
          } else {
            $("#difficulty option[value]").filter(function() {
              return +$(this).val() > 2;
            }).show();
            $("#difficulty option[value]").filter(function() {
              return +$(this).val() < 2;
            }).hide();
          }
        });
        </script>
    </body>
</html>
