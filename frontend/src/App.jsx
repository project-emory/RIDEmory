import React from "react";
import './assets/styles/index.css'
import {
    BrowserRouter as Router,
    Routes,
    Route
} from "react-router-dom"
import { Home, Rides } from "./pages";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/rides" element={<Rides />} />
            </Routes>
        </Router>
    );
}

export default App;
