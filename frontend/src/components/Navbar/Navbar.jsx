import React from "react";
import './navbar.scss'
import {logo} from "../../assets/images"
import { Link, useNavigate } from 'react-router-dom'

const Navbar = () => {
    const navigate = useNavigate()
    return(
        <nav>
      <div className="logo">
        <img src={logo} alt = "Logo"/>
      </div>
      <input type="checkbox" id="click"></input>
      <label htmlFor="click" className="menu-btn">
        <i className="fas fa-bars"></i>
      </label>
      <ul>
        <li><Link className="active" href="#">HOME</Link></li>
        <li><Link to="#">ABOUT US</Link></li>
        <li>
          <Link to="#">OUR SERVICES 
          <i className="fas fa-thin fa-chevron-down"></i></Link>
        </li>
        <li><Link to="contact">CONTACT US</Link></li>
        <li>
        <div className="search-box">
          <button className="btn-search"><i className="fas fa-search"></i></button>
          <input type="text" className="input-search" placeholder="Search here"></input>
        </div>
        </li>
      </ul>
    </nav>
    )
}

export default Navbar;