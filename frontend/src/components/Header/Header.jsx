import React from "react";
import './header.scss'
import { headerbus } from "../../assets/images";
import { Button } from "..";
import { useNavigate } from 'react-router-dom';

const Header = () => {

    const navigate = useNavigate();

    function handleClick() {
      navigate("/sign-in");
    }

    return (
        <div className="header">
            <div className="header-content">
                <h1>Don't Wait!</h1>
                <h1 className="title-2">Use RIDEmory!</h1>
                <p>A self-updating database of ride information for Emory students, accessible everywhere with real-time data.</p>
                <Button className='green-btn' onClick={handleClick}>GET STARTED</Button>
            </div>
            <img className="header-bus" src={headerbus} alt="bus" />
        </div>
    )
}

export default Header