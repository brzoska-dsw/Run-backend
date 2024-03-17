import React from "react";
import { Provider as AlertProvider } from "react-alert";
import AlertTemplate from "react-alert-template-basic";
import { PrimeReactProvider } from "primereact/api";
import Home from "./Home";

const options = {};

function App() {
  return (
    <AlertProvider template={AlertTemplate} {...options}>
      <PrimeReactProvider>
        <Home />
      </PrimeReactProvider>
    </AlertProvider>
  );
}

export default App;
