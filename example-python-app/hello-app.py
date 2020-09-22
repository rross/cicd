from flask import Flask
import os
import socket

app = Flask(__name__)

@app.route("/")
def hello():
    response = "Hello World!<br>" \
               "Version: 1.0.0<br>" \
               "Hostname: {hostname}<br>"
               
    return response.format(hostname=socket.gethostname())

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8080)
