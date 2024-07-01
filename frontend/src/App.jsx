import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Account from "./pages/Account.jsx";

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
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
