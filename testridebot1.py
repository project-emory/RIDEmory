#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov  6 10:20:51 2023

@author: alexlucas
"""

import os
import requests

from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET'])
def home():
    return 'You could put any content here you like, perhaps even a homepage for your bot!'


@app.route('/', methods=['POST'])
def receive():
    print('Incoming message:')
    
    # Prevent self-reply
    

    return 'ok', 200


def send(msg):
    url  = 'https://api.groupme.com/v3/bots/post'

    data = {
        'bot_id': os.getenv('BOT_ID'),
        'text': msg,
    }
    r = requests.post(url, data=data)