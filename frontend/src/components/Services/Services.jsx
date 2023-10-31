import React from "react";
import './services.scss'
import { trackbus1, service1, service2, service3 } from "../../assets/images";
import { Link } from "react-router-dom";

const Services = () => {
    return (
        <section className="services">
            <section className="services-section-1">
                <img className="services-bus" src={trackbus1} alt="bus" />
                <div className="services-content">
                    <h1>AUTOMATIC!</h1>
                    <h1>RIDE TRACKING!</h1>
                    <p> <span>RIDEmory</span>, a tracking system focuses on providing an intuitive and user-friendly interface that allows students to easily access the information they need about rides. Interactive maps display locations of rides in real-time, allowing our clients to plan their travels accordingly.</p>
                </div>
            </section>
            <h1>OUR SERVICES</h1>
            <section className="services-section-2">
                <div className="service-1">
                    <img src={service1} alt="service-1"/>
                    <h2>Using Routes</h2>
                    <p><Link to="#">Read More &gt;</Link></p>
                </div>
                <div className="service-2">
                    <img src={service2} alt="service-2" />
                    <h2>TRACK ALL RIDES</h2>
                    <p>RIDEmory data about the rides are currently accessible via our web.</p>
                </div>
                <div className="service-3">
                    <img src={service3} alt="service-3"/>
                    <h2>Available on Mobile</h2>
                    <p><Link to="#">Read More &gt;</Link></p>
                </div>
            </section>
        </section>
    )
}

export default Services