// --> retrieve messages based on new messages

// STEP 1: handshake
/*
const url = "https://push.groupme.com/faye";

const data = [
  {
    "channel": "/meta/handshake",
    "version": "1.0",
    "supportedConnectionTypes": ["long-polling"],
    "id": "1"
  }
];

const requestOptions = {
  method: "POST",
  headers: {
    'Content-Type': 'application/json' // Set the Content-Type header to JSON
  },
  body: JSON.stringify(data) // Serialize the array to JSON
};

async function runBot() {
  try {
    const response = await fetch(url, requestOptions);
    if (response.ok) {
      const responseData = await response.json();
      console.log("Response Data:", responseData);
    } else {
      console.error("Request Error: Status " + response.status);
      const errorText = await response.text();
      console.error("Error Response Text:", errorText);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

runBot();*/
 
// STEP 2: Retrieve user ID
/*

const url = "https://api.groupme.com/v3/users/me?token={token}";

const requestOptions = {
  method: "GET",
  headers: {
    'Content-Type': 'application/json' // Set the Content-Type header to JSON
  },
};

async function runBot() {
  try {
    const response = await fetch(url, requestOptions);
    if (response.ok) {
      const responseData = await response.json();
      console.log("Response Data:", responseData);
    } else {
      console.error("Request Error: Status " + response.status);
      const errorText = await response.text();
      console.error("Error Response Text:", errorText);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

runBot();*/


// STEP 3: subscribe to chat
/*
const url = "https://push.groupme.com/faye";
const userChannelSubscriptionData = [
  {
    "channel": "/meta/subscribe",
    "clientId": "{clientID}",
    "subscription": "/user/{userID}", // Replace <userid> with the actual user ID
    "id": "{id#}",
    "ext": {
      "access_token": "{token}", 
    }
  }
];

const requestOptions = {
  method: "POST",
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(userChannelSubscriptionData)
};

async function subscribeToUserChannel() {
  try {
    const response = await fetch(url, requestOptions);
    if (response.ok) {
      const responseData = await response.json();
      console.log("User Channel Subscription Response Data:", responseData);
    } else {
      console.error("User Channel Subscription Error: Status " + response.status);
      const errorText = await response.text();
      console.error("User Channel Subscription Error Response Text:", errorText);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

subscribeToUserChannel();  
*/
// STEP 4: Subscribe to Group channel
/*
const url = "https://push.groupme.com/faye";
const groupChannelSubscriptionData = [
  {
    "channel": "/meta/subscribe",
    "clientId": "{clientID}",
    "subscription": "/group/{groupID}",
    "id": "{id}",
    "ext": {
      "access_token": "{token}", 
    }
  }
];

const requestOptions = {
  method: "POST",
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(groupChannelSubscriptionData)
};

async function subscribeToGroupChannel() {
  try {
    const response = await fetch(url, requestOptions);
    if (response.ok) {
      const responseData = await response.json();
      console.log("Group Channel Subscription Response Data:", responseData);
    } else {
      console.error("Group Channel Subscription Error: Status " + response.status);
      const errorText = await response.text();
      console.error("Group Channel Subscription Error Response Text:", errorText);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

subscribeToGroupChannel();
*/
// Step 5: poll for data 

/*
const url = "https://push.groupme.com/faye";
const connectRequestData = [
  {
    "channel": "/meta/connect",
    "clientId": "{clientID}", // Replace with your client ID
    "connectionType": "websocket",
    "id": "{id#}"
  }
];

const requestOptions = {
  method: "POST",
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(connectRequestData)
};

async function switchToWebsockets() {
  try {
    const response = await fetch(url, requestOptions);
    if (response.ok) {
      const responseData = await response.json();
      console.log("Switch to Websockets Response Data:", responseData);
    } else {
      console.error("Switch to Websockets Error: Status " + response.status);
      const errorText = await response.text();
      console.error("Switch to Websockets Error Response Text:", errorText);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

switchToWebsockets();*/
