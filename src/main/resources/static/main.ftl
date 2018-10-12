<!DOCTYPE HTML>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style>
h1 {
    color: #008CBA;
    text-align: center;
}
p.serif {
    font-family: "Times New Roman", Times, serif;
    text-align: center;
}
table, th, td {
    border: 1px solid white;
    border-collapse: collapse;
    background-color: #dddddd;
    text-align: left;
    padding: 8px;


}
table {
    width: 50%;
    border-spacing: 5px;
    margin: auto;
}
body {
    background-color: lightblue;

}
input[type=text] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid white;
    border-radius: 4px;
}
input[type=date] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid white;
    border-radius: 4px;
}
input[type=button], input[type=submit], input[type=reset] {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
}
.button {
    background-color: #008CBA;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.item1 { grid-area: header;}
.item2 { grid-area: menu; }
.item3 { grid-area: main; }
.item4 { grid-area: right; }
.item5 { grid-area: footer; }

.grid-container {
    display: grid;
    grid-template-areas:
            'header header header header header header'
            'menu main main main main right'
            'footer footer footer footer footer footer';
    grid-gap: 3px;
    background-color: lightgrey;
    padding: 10px;
    grid-template-rows: 200px auto;

}
.grid-container > div {
    background-color: aliceblue;
    text-align: center;
    padding: 20px 0;
    font-size: 30px;

}
</style>
</head>



<body>
<div class="grid-container">
    <div class = "item1">Technical and Managerial Tutorials

    </div>



    <div class="item2">MENU

        <div>
            <form method="post">
                Date: <input type="date" name="date">
                <br>
                Person: <input type="text" name="codes", required="true">
                <br>
                <input type="submit">
            </form>
        </div>
        <div>
        <form method="post">
            <select name="cars" multiple>
                <option value="volvo">${keys}</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
            <input type="submit">
        </form>
        </div>
    </div>



    <div class="item3">
        <p>Click the button to print the current page.</p>

        <button onclick="myFunction()">Print this page</button>

        <script>
function myFunction() {
    window.print();
}
</script>
        <!--<form method="post">

            <input type="text" name="name" placeholder="firstname"/>
            <input type="text" name="email" placeholder="lastname"/>
            <button class="button" type="submit">Enter</button>

        </form>-->

        <table>
            <tr>
                <th>code</th>
                <th></th>
                <th>email</th>
            </tr>




            <tr>
                <td><b></b></td>
                <td><b></b></td>
            </tr>



        </table>

    </div>
    <div class="item4">RIGHT
    </div>
    <div class="item5">FOOTER
    </div>

</div>

</body>



</html>