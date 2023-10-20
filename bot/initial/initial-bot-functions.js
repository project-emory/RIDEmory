// Initial bot functions

// --> group_id
/*
const url = "https://api.groupme.com/v3/groups?token={token}"
const requestOptions = {
    method: "GET",
};
  
  async function runBot() {
    try {
      const response = await fetch(url, requestOptions);
      const responseData = await response.json();
      console.log(responseData);
    } catch (error) {
      console.error("Error:", error);
    }
  }
  
  runBot();*/

// --> create bot

/*
const token = ""
const url = 'https://api.groupme.com/v3/groups/{group_id}/messages?token={token}'

const request = new Request(url)

async function getData(){
    try{
        const response = await fetch(request)
        const data = await response.json()
        if (response.status === 200){
            console.log('Success', JSON.stringify(data))
            //const messages = JSON.parse(data)
            //console.log(messages)
        } else{
            console.log('Server Error', data.error.message) // ex. invalid token
        }
        

  
    } catch(error){
        console.log('Error', error) // could not fetch ex. wrong URL
    }
}

getData()*/

// --> bot sends message via running code
/*
const url = "https://api.groupme.com/v3/bots/post"

const data = {
    
    "bot_id"  : "{bot_id}},
    "text"    : "{message}"
    
};
  
const requestOptions = {
    method: "POST",
    body: JSON.stringify(data)
};
  
  async function runBot() {
    try {
      const response = await fetch(url, requestOptions);
      const responseData = await response.json();
    } catch (error) {
      console.error("Error:", error);
    }
  }
  
  runBot();
*/

