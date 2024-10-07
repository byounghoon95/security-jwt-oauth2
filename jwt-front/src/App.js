import Join from "./login/Join";
import Main from "./login/Main";
import { BrowserRouter, Route, Routes } from "react-router-dom";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/join" element={<Join />} />
      </Routes>
  </BrowserRouter>
  )
}

export default App;
