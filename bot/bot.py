import os
import requests

from flask import Flask, request
from pyngrok import ngrok


app = Flask(__name__)
app.config["TESTING"] = True
bot_id = open("secret.txt", "r").read()


def init_webhooks(base_url):
    pass


@app.route("/", methods=["GET"])
def home():
    return (
        "You could put any content here you like, perhaps even a homepage for your bot!"
    )


@app.route("/sendmanual", methods=["POST"])
def sendmanual():
    send("hi")
    print(request.get_json())
    return "ok", 200


@app.route("/", methods=["POST"])
def receive():
    print("Incoming message:")
    print(request.get_json())

    # Prevent self-reply
    if request.data["sender_type"] != "bot":
        send("received")
        # if request.data["text"].startswith("/ping"):
        #     send(request.data["name"] + " pinged me!")

    return "ok", 200


def send(msg):
    url = "https://api.groupme.com/v3/bots/post"

    data = {
        "bot_id": bot_id,
        "text": msg,
    }

    r = requests.post(url, json=data)


public_url = ngrok.connect(5000).public_url
print(public_url)
app.config["BASE_URL"] = public_url
init_webhooks(public_url)
