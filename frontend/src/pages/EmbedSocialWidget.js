import React, { Component } from "react";

class EmbedSocialWidget extends Component {
    componentDidMount() {       
        (function(d, s, id) { 
            var js; 
            if (d.getElementById(id)) {
                return;
            } 
            js = d.createElement(s); 
            js.id = id; 
            js.src = "https://embedsocial.com/cdn/ht.js"; 
            d.getElementsByTagName("head")[0].appendChild(js); 
        })(document, "script", "EmbedSocialHashtagScript");
    }
    render() {
        return (
            <div 
                class="embedsocial-hashtag" 
                data-ref="f718fc77f3f7142d374023362f2fd1f2aa471605"
            ></div>
        );
    }
}

export default EmbedSocialWidget;