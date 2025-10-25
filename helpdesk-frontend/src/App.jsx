import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import { Button } from "./components/ui/button";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <h1>This is my application</h1>
      <Button variant={"outline"}>Click Me</Button>
    </>
  );
}

export default App;
