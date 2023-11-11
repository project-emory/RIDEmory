import os
import requests

from flask import Flask, request
from pyngrok import ngrok


app = Flask(__name__)
app.config["TESTING"] = True
secret = open("secret.txt", "r")
bot_id = secret.readline().rstrip()
user_token = secret.readline().rstrip()


def init_webhooks(base_url):
    pass


# not possible to update callback
# def update_callback(token, url):
#     json = {"bot": {"callback_url": url}}

#     print(
#         requests.post(url="https://api.groupme.com/v3/bots?token=" + token, json=json)
#     )


@app.route("/", methods=["GET"])
def home():
    return (
        "You could put any content here you like, perhaps even a homepage for your bot!"
    )


@app.route("/sendmanual", methods=["POST"])
def sendmanual():
    json = request.get_json()
    print(bot_id)
    send(json["msg"])
    return "ok", 200


@app.route("/", methods=["POST"])
def receive():
    print("Incoming message:")
    json = request.get_json()

    # Prevent self-reply
    if json["sender_type"] != "bot":
        if json["text"].startswith("/ping"):
            send(json["name"] + " pinged me!")

    return "ok", 200


def send(msg):
    url = "https://api.groupme.com/v3/bots/post"

    data = {
        "bot_id": bot_id,
        "text": msg,
    }

    requests.post(url, json=data)


public_url = ngrok.connect(5000).public_url
print(public_url)
init_webhooks(public_url)
