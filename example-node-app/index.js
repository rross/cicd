var express = require('express');
var os = require('os');

var app = express();

app.get('/', function (req, res) {
  res.send('Hello World!' + '<br>' +
		   'Version: 1.0.0' + '<br>' +
	'Hostname: ' + os.hostname() +  '<br>');
});

app.listen(8080, function () {
  console.log('Hello World App listening on port 8080!');
});

// starting from scratch
// npm init
// npm install express --save
// npm install os --save

// Run locally
// node index.js