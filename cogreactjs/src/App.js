import { Route, Routes, useLocation } from "react-router";
import Sidebar from "./Sidebar";
import styled from "styled-components";

//Pages
import HomePage from "./Pages/HomePage";
import RegistrationPage from "./Pages/RegistrationPage";
import LoginPage from "./Pages/LoginPage";

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

function MultiPathRoute({ paths, element }) {
  const location = useLocation();
  if (paths.includes(location.pathname)) {
    return element;
  }
  return null;
}


function App() {
  const location = useLocation();
   return (
      <>
        <Sidebar />
        <Pages>
            <Routes location={location} key={location.pathname}>
             <Route
                path="*"
                element={<MultiPathRoute paths={["/", "/home"]} element={<HomePage />} />}
              />

               <Route path="/register" element={<RegistrationPage />} />
               <Route path="/login" element={<LoginPage />} />

            </Routes>
        </Pages>
      </>
    );
  }
 export default App;