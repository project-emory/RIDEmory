import os
import requests

from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET'])
def home():
    return 'Welcome to RIDEmory GroupME Test Bot!'


@app.route('/', methods=['POST'])
def receive():
    print('Incoming message:')
   # print(data)

    # Prevent self-reply
   # if data['sender_type'] != 'bot':
     #   if data['text'].startswith('/ping'):
      #      send(data['name'] + ' pinged me!')

    return 'ok', 200


def send(msg):
    url  = 'https://api.groupme.com/v3/bots/post'

    data = {
        'bot_id': os.getenv('BOT_ID'),
        'text': msg,
    }
    r = requests.post(url, data=data)
