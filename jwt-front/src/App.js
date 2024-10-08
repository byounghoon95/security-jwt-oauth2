import { BrowserRouter, Route, Routes } from "react-router-dom";
import Main from "./login/Main";
import Join from "./login/Join";
import Login from "./login/Login";
import LoginInput from "./login/LoginInput";
const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/join" element={<Join />} />
        <Route path="/login" element={<LoginInput />} />
        <Route path="/main" element={<Main />} />
      </Routes>
  </BrowserRouter>
  )
}

export default App;
