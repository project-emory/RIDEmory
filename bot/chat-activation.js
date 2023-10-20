const express = require('express'); 
const axios = require('axios').default;
const app = express();
const port = 3000; 

const url = 'https://api.groupme.com/v3/bots/post';

const botId = '';

app.use(express.json());


app.get('/', (req, res) => {
    res.send('Hello, World!'); 
  });


function sendMessage(message) {
    axios.post(url, {
        text: message,
        bot_id: botId
    })
        .then(response => console.log(response.statusText))
        .catch(error => console.log(error.response.data))

}

app.post('/bot', (req, res) => {
    const body = req.body;

    if (body.text.includes('pandas bot'))
        sendMessage('Hello, when is your flight?');

    if (body.text.includes('flight'))
        console.log(body.text);
    res.sendStatus(200);
})


app.listen(port, () => {
    sendMessage("here");
    console.log(`Example app listening at http://localhost:${port}`);
})