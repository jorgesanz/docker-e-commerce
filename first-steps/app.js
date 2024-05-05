const http = require('http');
const os = require('os')

console.log("Server starting...")

const handler = function (request, response) {
    console.log("Received request");
    response.writeHead(200);
    response.end("Hello!\n");
};
const www = http.createServer(handler);
www.listen(8080);