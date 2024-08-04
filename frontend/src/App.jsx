import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Account from "./pages/Account.jsx";
import Login from "./pages/Login.jsx";
import Signup from "./Signup.jsx";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/about" element={<About />} />
                    <Route path="/account" element={<Account />} />
                    <Route
                        path="/account-redirect"
                        element={<Navigate to="/account" />}
                    />
                    <Route path="/login" element={<Login />} />
                    <Route path="/signup" element={<Signup />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
