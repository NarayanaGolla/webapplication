import { Route, Routes, useLocation } from "react-router";
import Sidebar from "./Sidebar";
import styled from "styled-components";
import HomePage from "./Pages/HomePage";

const Pages = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;

  h1 {
    font-size: calc(2rem + 2vw);
    background: linear-gradient(to right, #803bec 30%, #1b1b1b 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
  }
`;

function App() {
  const location = useLocation();
   return (
      <>
        <Sidebar />
        <Pages>
            <Routes location={location} key={location.pathname}>
               <Route path="/" element={<HomePage />} />
            </Routes>
        </Pages>
      </>
    );
  }
 export default App;