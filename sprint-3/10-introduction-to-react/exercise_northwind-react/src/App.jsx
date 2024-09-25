import Navigation from "./components/navigation/Navigation"
import EmployeesPage from "./components/employees/employees-page/EmployeesPage"
import { useState } from "react"



function App() {

  const [pageName, setPageName] = useState("details");
  const pageChangeHandler = (pageName);

  return (
    <>
      <Navigation></Navigation>

      <EmployeesPage></EmployeesPage>

    </>
  )
}

export default App
