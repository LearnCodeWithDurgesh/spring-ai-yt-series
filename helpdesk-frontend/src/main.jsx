import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import { BrowserRouter, Route, Routes } from "react-router";
import ChatHome from "./pages/ChatHome.jsx";
import Chat from "./pages/Chat.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="" element={<ChatHome />} />
        <Route path="/chat" element={<Chat />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>
);
