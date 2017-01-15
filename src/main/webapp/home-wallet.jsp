<%--
  Created by IntelliJ IDEA.
  User: root_pc
  Date: 1/15/2017
  Time: 3:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/css/style.css">
  <script src="/js/jquery-1.10.2.js"></script>
  <script src="/js/controller.js"></script>
  <title>Player Wallet Service</title>
</head>

<body>
<div class="main">
<h1>Player Wallet</h1>
  <div style="">
      <h3>Find Player By ID </h3> <input id="player_id_input" type="number" >
  </input> <button id="player_search" class="button" onclick="clickSearch()">Search</button>
  </div>
  <div id="createWallet">
     <h4>Doesn't Exist</h4>
    <button id="create_new_wallet" class="button1" onclick="createNewWallet()">Create Wallet</button>
  </div>
  <div id="wallet">
      <table id="tb" class="tables" style="margin-top: 15px;">
          <tbody>
          <tr>
          <td><label>Current Balance:</label> </td> <td><span id="balance"></span></td>
          </tr>
          <tr>
         <td><label>Operation Type:</label></td>
              <td><select id="operationType">
                    <option value="deposit">Deposit</option>
                    <option value="withdraw">Withdraw</option>
                   </select></td>
          </tr>
          <tr>
            <td> <label>Amount : </label></td>
             <td> <input id="operation_amount" type="number" style="width: 78px;"> </input> </td>
          </tr>
          </tbody>
      </table>
      <div>
          <button id="doOperation" style="width: 100px; margin-left: 50px;" onclick="doTransfers()">Transfer</button>
      </div>
  </div>
    <%--<label id="desc">  </label>--%>
    </div>
</body>
</html>
